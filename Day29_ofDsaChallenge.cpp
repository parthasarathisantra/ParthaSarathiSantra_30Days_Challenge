#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long solve(vector<int> arr)
{
    int n = arr.size();

    if (n <= 1)
        return 0;
    vector<int> A(n + 1);

    for (int i = 0; i < n; i++)
        A[i + 1] = arr[i];
    vector<int> lg(n + 1);

    lg[1] = 0;

    for (int i = 2; i <= n; i++)
        lg[i] = lg[i / 2] + 1;
    vector<vector<int>> st(20, vector<int>(n + 1));

    for (int i = 1; i <= n; i++)
        st[0][i] = i;

    for (int j = 1; j <= 19; j++)
    {
        for (int i = 1; i + (1 << j) - 1 <= n; i++)
        {
            int left_idx = st[j - 1][i];
            int right_idx = st[j - 1][i + (1 << (j - 1))];

            if (A[left_idx] >= A[right_idx])
                st[j][i] = left_idx;
            else
                st[j][i] = right_idx;
        }
    }

    auto query_rmq = [&](int L, int R)
    {
        int j = lg[R - L + 1];

        int left_idx = st[j][L];
        int right_idx = st[j][R - (1 << j) + 1];

        if (A[left_idx] >= A[right_idx])
            return left_idx;

        return right_idx;
    };

    struct QueryNode
    {
        int V;
        int sign;
        int next;
    };

    vector<QueryNode> q_nodes;

    vector<int> q_head(n + 1, -1);

    auto add_query = [&](int L, int R, int V)
    {
        if (L > R)
            return;

        q_nodes.push_back({V, 1, q_head[R]});
        q_head[R] = (int)q_nodes.size() - 1;

        if (L - 1 >= 1)
        {
            q_nodes.push_back({V, -1, q_head[L - 1]});
            q_head[L - 1] = (int)q_nodes.size() - 1;
        }
    };

    long long direct_ans = 0;

    struct Job
    {
        int L;
        int R;
    };

    vector<Job> stack;

    stack.push_back({1, n});

    while (!stack.empty())
    {
        Job curr = stack.back();
        stack.pop_back();

        int L = curr.L;
        int R = curr.R;

        if (L >= R)
            continue;

        int m = query_rmq(L, R);

        int left_len = m - L;
        int right_len = R - m;

        if (left_len < right_len)
        {
            for (int i = L; i <= m - 1; i++)
            {
                int V = A[m] / A[i];

                add_query(m + 1, R, V);

                if (A[i] == 1)
                    direct_ans++;
            }

            add_query(m + 1, R, 1);
        }
        else
        {
            for (int j = m + 1; j <= R; j++)
            {
                int V = A[m] / A[j];

                add_query(L, m - 1, V);

                if (A[j] == 1)
                    direct_ans++;
            }

            add_query(L, m - 1, 1);
        }

        stack.push_back({L, m - 1});
        stack.push_back({m + 1, R});
    }
    vector<int> vals;

    for (int i = 1; i <= n; i++)
        vals.push_back(A[i]);

    sort(vals.begin(), vals.end());

    vals.erase(unique(vals.begin(), vals.end()), vals.end());

    auto get_rank_le = [&](int V)
    {
        return (int)(upper_bound(vals.begin(), vals.end(), V) - vals.begin());
    };
    int MAX_VAL = vals.size();

    vector<int> bit(MAX_VAL + 1, 0);

    auto fenwick_add = [&](int idx, int val)
    {
        for (; idx <= MAX_VAL; idx += idx & -idx)
            bit[idx] += val;
    };

    auto fenwick_get = [&](int idx)
    {
        int sum = 0;

        for (; idx > 0; idx -= idx & -idx)
            sum += bit[idx];

        return sum;
    };

    long long final_ans = direct_ans;

    for (int i = 1; i <= n; i++)
    {
        int rank = get_rank_le(A[i]);

        fenwick_add(rank, 1);

        for (int curr = q_head[i]; curr != -1; curr = q_nodes[curr].next)
        {
            int r = get_rank_le(q_nodes[curr].V);

            final_ans +=
                (long long)q_nodes[curr].sign * fenwick_get(r);
        }
    }

    return final_ans;
}

int main()
{
    int n;

    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << solve(arr) << endl;

    return 0;
}
#include<bits/stdc++.h>
#include<iostream>
#include<stdio.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace std;
using namespace __gnu_pbds;

#define fr(i,j,n)   for(int i=j;i<(n);++i)
#define bk(i,j,n)   for(int i=j;i>=n;--i)
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl "\n"
#define MOD 1000000007
#define run ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0)
#define ordered_set tree<ll , null_type, less<ll>, rb_tree_tag, tree_order_statistics_node_update>

typedef long long ll;

ll dp[5005][5005],pre[5005][5005],lcp[5005][5005];
string s;
ll n;

void init()
{
    bk(i,n,1)
    {
        bk(j,n,1)
        {
            if(s[i]==s[j])
            {
                lcp[i][j]=lcp[i+1][j+1]+1;
            }else{
            lcp[i][j]=0;}
        }
    }
}
bool chk(ll i1,ll i2,ll len)
{
    if(lcp[i1][i2]>=len)
        return 0;
    return s[i1+lcp[i1][i2]]<s[i2+lcp[i1][i2]];
}

int main()
{
    //run;

    cin>>n;

    cin>>s;
    s='*'+s;
    init();
    fr(i,1,n+1)
    {
        dp[i][i]=1;
        fr(j,1,n+1)
        {
            pre[i][j]+=pre[i-1][j]+dp[i][j];
            pre[i][j]%=MOD;
        }

    }








    return 0;
}

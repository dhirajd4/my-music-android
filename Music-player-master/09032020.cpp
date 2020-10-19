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
#define debug1(x) cout<<#x<<" "<<x<<endl;
#define debug2(x,y) cout<<#x<<" "<<x<<" "<<#y<<" "<<y<<endl;
#define debug3(x,y,z) cout<<#x<<" "<<x<<" "<<#y<<" "<<y<<" "<<#z<<" "<<z<<endl;

#define run ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0)
#define ordered_set tree<ll , null_type, less<ll>, rb_tree_tag, tree_order_statistics_node_update>

typedef int ll;
ll modpower(ll a,ll b,ll c)
{
	ll res=1;
	while(b)
	{
		if(b&1LL)
			res=(res*a)%c;
		a=(a*a)%c;
		b>>=1;
	}
	return res;
}
vector<ll> pp;
void SieveOfEratosthenes(int n)
{
    // Create a boolean array "prime[0..n]" and initialize
    // all entries it as true. A value in prime[i] will
    // finally be false if i is Not a prime, else true.
    bool prime[n+1];
    memset(prime, true, sizeof(prime));

    for (int p=2; p*p<=n; p++)
    {
        // If prime[p] is not changed, then it is a prime
        if (prime[p] == true)
        {
            // Update all multiples of p greater than or
            // equal to the square of it
            // numbers which are multiple of p and are
            // less than p^2 are already been marked.
            for (int i=p*p; i<=n; i += p)
                prime[i] = false;
        }
    }

    // Print all prime numbers
    for (int p=2; p<=n; p++)
       if (prime[p])
          {
              pp.pb(p);
             // cout << p << " ";
          }
}


int main()
{
   // run;
    ll t;
    cin>>t;


    SieveOfEratosthenes(1000);



    while(t--)
    {
         ll n;
         cin>>n;
         ll a[n];
         set<ll> s;
         map<ll,ll> m;
         ll siz=pp.size();
        // cout<<siz<<endl;
         set<ll> vv[siz];
         vector<ll> vind[n];


         fr(i,0,n)
         {
             cin>>a[i];
             fr(j,0,siz)
             {
                 if(a[i]%pp[j]==0)
                 {
                     vv[j].insert(i);
                     vind[i].pb(j);
                   //  cout<<i<<" "<<j<<endl;
                 }
             }

             s.insert(a[i]);
         }

         ll col[1001];
         fr(i,0,1001)
         {
             col[i]=0;
         }

         ll oo=s.size();
         multiset<pair<ll,ll>  > vsiz;
         fr(i,0,siz)
         {

             vsiz.insert({-vv[i].size(),i});
         }
         ll asa=1;
         ll colo=1;
         ll vis[200]={0};
         while(1)
         {
            // cout<<"pop";
             if(vsiz.empty())
                {
                    colo--;
                    break;
                }
             auto it=*vsiz.begin();

             ll o=-1*it.F;
             ll o1=it.S;
             vis[o1]=1;
             if(!o)
             {
                 break;
             }
             vsiz.erase(vsiz.begin());
             ll f=0;
             //cout<<"po"<<vv[o1].size()<<" "<<o1<<endl;
             for(auto ii=vv[o1].begin();ii!=vv[o1].end();ii++)
             {
                // cout<<*ii<<" "<<o1<<endl;

                 if(!col[*ii])
                 {
                     f=1;
                     col[*ii]=colo;
                     asa=max(asa,colo);
                     ll po=*ii;
                     fr(j,0,siz)
                     {
                         if(j!=o1)
                         {
                             if(vv[j].find(po)!=vv[j].end() && !vis[j])
                             {
                                 vsiz.erase({-vv[j].size(),j});
                                 vv[j].erase(vv[j].find(po));
                                 vsiz.insert({-vv[j].size(),j});
                             }
                         }
                     }
                     /*fr(j,0,vind[po].size())
                     {
                         if(  vind[po][j]!=o1 && vv[vind[po][j]].find(po)!=vv[vind[po][j]].end())//binary_search(vv[vind[po][j]].begin(),vv[vind[po][j]].end(),po))
                         {
                             vsiz.erase(vsiz.find({-vv[vind[po][j]].size(),vind[po][j]}));
                             vv[vind[po][j]].erase(vv[vind[po][j]].find(po));

                         vsiz.insert({-vv[vind[po][j]].size(),vind[po][j]});
                         }
                     }*/
                 }

             }
               if(f)
                colo++;


         }

       /*  if(asa>11)
         {
             fr(i,0,10000000000)
             {
                 SieveOfEratosthenes(121);
             }
         }*/
         cout<<asa<<endl;
         fr(i,0,n)
         {

             cout<<col[i]<<" ";
         }
         cout<<endl;


         /*ll ind=1;
         fr(i,0,11)
         {
             vector<ll> v;
             if(s.empty())
             {
                 ind=i;
                 break;
             }
             ll o=*s.begin();
             for(auto it=s.begin();it!=s.end();it++)
             {
                 if(__gcd(*it,o)>1)
                 {
                     m[o]=i+1;
                     m[*it]=i+1;
                     v.pb(*it);
                 }
             }
             fr(j,0,v.size())
             {
                 s.erase(v[j]);
             }
         }
         cout<<ind<<endl;
         fr(i,0,n)
         {
             cout<<m[a[i]]<<" "<<a[i]<<endl;
         }
         cout<<endl;
        // cout<<__gcd(808,291);
*/





    }





}

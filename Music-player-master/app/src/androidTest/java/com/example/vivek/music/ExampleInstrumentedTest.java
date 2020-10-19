package com.example.vivek.music;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        int main()
{
	boost
	ll t;
	cin>>t;
	while(t--)
	{
		ll n;
		cin>>n;
		ll a[n];
		for(ll i=0;i<n;i++)
		{
			cin>>a[i];
		}
		ll pos=0,neg=0,flag=-1;
		ll sum=0;
		for(ll i=0;i<n;i++)
		{
			if(a[i]>=0&&flag!=0)
			{
				pos=max(pos,a[i]);
				sum+=neg;
				neg=-inf;
				flag=0;
			}
			else if(a[i]<0&&flag!=1)
			{
				if(neg==0)
					neg=-inf;
				neg=max(neg,a[i]);
				sum+=pos;
				pos=0;
				flag=1;
			}
			else if(a[i]>0&&flag==0)
			{
				pos=max(pos,a[i]);
			}
			else if(a[i]<0&&flag==1)
				neg=max(neg,a[i]);
		}
		if(flag==0&&neg!=-inf)
			sum+=neg;
		else
			sum+=pos;
		cout<<sum<<endl;
	}

	return 0;
}

        assertEquals("com.example.vivek.music", appContext.getPackageName());
    }
}

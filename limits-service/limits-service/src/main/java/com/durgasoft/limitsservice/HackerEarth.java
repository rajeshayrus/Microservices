package com.durgasoft.limitsservice;

class HackerEarth 
{
	
		public static void main(String[] args)
	{
		
		String s = "aabcccabba";
		int length = s.length()/2;
		String sr= s.substring(s.length()/2);
		String sl= s.substring(0,s.length()/2);
		StringBuffer sb = new StringBuffer(sr);
		
		System.out.println(sr+"....."+sl);
		
		
	}
  
}
class sample{
    /*******************PROBLEM-1****************/
    //TC:0(nlogn)
//SC:0(n)
    class Solution {
        public int nthUglyNumber(int n) {
            if(n==0 || n==1){
                return n;
            }
            int count=0;
            long curr=0;
            PriorityQueue<Long> heap=new PriorityQueue<>();
            HashSet<Long> seen=new HashSet<>();
            int[] nums=new int[]{2,3,5};
            heap.add((long)1);
            while(count<n){
                curr=heap.poll();
                count++;
                for(int each:nums){
                    if(!seen.contains(each*curr)){
                        seen.add(each*curr);
                        heap.add(each*curr);
                    }
                }
            }
            return (int)curr;
        }
    }

    //TC:0(n)
//SC:0(1)
    class Solution {
        public int nthUglyNumber(int n) {
            if(n==1 || n==0){
                return n;
            }
            int[] result=new int[n];
            result[0]=1;
            int p2=0,p3=0,p5=0;
            int n2=2,n3=3,n5=5;
            for(int i=1;i<n;i++){
                result[i]=Math.min(Math.min(n2,n3),n5);
                if(result[i]==n2){
                    p2++;
                    n2=result[p2]*2;
                }
                if(result[i]==n3){
                    p3++;
                    n3=result[p3]*3;
                }
                if(result[i]==n5){
                    p5++;
                    n5=result[p5]*5;
                }
            }
            return result[n-1];
        }
    }
    /*******************PROBLEM-2****************/

    //TC:0(n*n)
//SC:0(n*n)
    class Solution {
        public String longestPalindrome(String s) {
            if(s==null || s.length()==0){
                return "";
            }
            int n=s.length(),max=0,start=0,end=0;
            boolean[][] dp=new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    if((s.charAt(i)==s.charAt(j)) && ((i-j-1<2) || (dp[i-1][j+1]==true))){
                        dp[i][j]=true;
                    }
                    if(dp[i][j]==true){
                        if(i-j+1>max){
                            max=i-j+1;
                            start=j;
                            end=i;
                        }
                    }
                }
            }
            return s.substring(start,end+1).toString();
        }
    }

    //TC:0(N*N)
    //SC:0(1)
    //TC:0(n*n)
//SC:0(n*n)
    class Solution {
        int max=0,start=0,end=0;
        public String longestPalindrome(String s) {
            if(s==null || s.length()==0){
                return "";
            }
            int n=s.length();
            for(int i=0;i<n;i++){
                expandAroundCenter(s,i,i);
                if(i<n-1){
                    expandAroundCenter(s,i,i+1);
                }
            }
            return s.substring(start,end+1).toString();
        }

        private void expandAroundCenter(String s,int l,int r){
            while((l>=0 && r<s.length())&& (s.charAt(l)==s.charAt(r))){
                l--;
                r++;
            }
            l++;
            r--;
            if(max<r-l+1){
                max=r-l+1;
                start=l;
                end=r;
            }
        }
    }

}
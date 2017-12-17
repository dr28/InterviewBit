package com.dr.level6.HeapsAndMaps;
/*Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this link

So now the problem statement for this question is:

How many distinct Max Heap can be made from n distinct integers

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely
filled, and all nodes are as far left as possible. )
Every node is greater than all its children
Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers

Following are the possible max heaps from these 4 numbers :

         4
       /  \
      3   2
     /
    1
         4
       /  \
      2   3
     /
    1
        4
       /  \
      3   1
     /
    2
These are the only possible 3 distinct max heaps possible for 4 distinct elements.

Implement the below function to return the number of distinct Max Heaps that is possible from n distinct elements.

As the final answer can be very large output your answer modulo 1000000007

Input Constraints : n <= 100

 NOTE: Note that even though constraints are mentioned for this problem, for most problems on InterviewBit, constraints are intentionally
 left out. In real interviews, the interviewer might not disclose constraints and ask you to do the best you can do. */
public class Way2FormMaxHeap {
    long[] dp;  	/* dp[i] = number of max heaps for i distinct integers */
    long[][] nck;	/* nck[i][j] = i choose j if i>=j else 0 */
    int[] log2;		/* log2[i] = int(log base 2 of i) */

    final long MOD = 1000000007;

    public long choose(int n,int k)
    {
        if(k>n)
            return 0;
        if(n<=1)
            return 1;
        if(k==0)
            return 1;

        if(nck[n][k]!=-1)
            return nck[n][k];

        long answer = choose(n-1,k-1) + choose(n-1,k);
        answer%=MOD;
        nck[n][k] = answer;
        return answer;
    }

    public int getL(int n)
    {
        if(n==1)
            return 0;

        int h = log2[n];
        int p = n - ((1<<(h)) - 1);
        int m = (1<<h);
        if(p>=(m/2))
            return (1<<(h)) - 1;
        else
            return (1<<(h)) - 1 - ((m/2) - p);
    }

    public int solve(int A) {
        dp = new long[A+1];
        for(int i=0;i<=A;i++)
            dp[i]=-1;

        nck = new long[A+1][A+1];
        for(int i=0;i<=A;i++)
            for(int j=0;j<=A;j++)
                nck[i][j] = -1;

        log2 = new int[A+1];
        int currLogAnswer = -1;
        int currPower2 = 1;
        for(int i=1;i<=A;i++)
        {
            if(currPower2==i) {
                currLogAnswer++;
                currPower2*=2;
            }
            log2[i] = currLogAnswer;
        }
        return (int)getNumberOfMaxHeaps(A);
    }


    public long getNumberOfMaxHeaps(int n)
    {
        if(n<=1)
            return 1;

        if(dp[n]!=-1)
            return dp[n];

        int L = getL(n);
        long ans = (choose(n-1,L)*getNumberOfMaxHeaps(L))%MOD*(getNumberOfMaxHeaps(n-1-L));
        ans%=MOD;
        dp[n] = ans;
        return ans;
    }
    
    public static void main(String[] args){
        System.out.print(new Way2FormMaxHeap().solve(5));
    }
}

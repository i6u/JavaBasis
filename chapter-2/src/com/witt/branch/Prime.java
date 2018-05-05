package com.witt.branch;

class Prime {

    public static int calculateNumber(int Nmax) {

        boolean[] isPrime = new boolean[Nmax + 1];
        for (int i = 3; i <= Nmax; i += 2) {
            isPrime[i] = true;
        }

        isPrime[2] = true;

        for (int i = 3; i <= Math.sqrt(Nmax); i += 2) {
            if (isPrime[i] == true) {
                for (int j = i * i; j <= Nmax; j += 2 * i)
                    isPrime[j] = false;
            }
        }
        int primeNum = 0;
        for (int i = 1; i <= Nmax; i++) {
            if (isPrime[i] == true)
                primeNum++;
        }
        return primeNum;
    }

    public static void main(String[] args) {
        final int Nmax = 2000000000;
        long startTime = System.currentTimeMillis();
        int primeNum = Prime.calculateNumber(Nmax);
        long timeSpent = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("The prime numbers from 1 to " + Nmax + " is " + primeNum);
        System.out.println("Time spent : " + timeSpent + " s");
    }
}

class Prime1{

    public static int calculateNumber(int Nmax){
        boolean[] isPrime=new boolean[Nmax+1];
        for(int i=3;i<=Nmax;i+=2)
            isPrime[i]=true;
        isPrime[2]=true;
        for(int i=3;i<=Math.sqrt(Nmax);i+=2){
            if(isPrime[i]){
                int j=i*i;
                int n=i;
                while(j<=Nmax){
                    isPrime[j]=false;
                    while(Nmax/j>=i){
                        isPrime[j*=i]=false;
                    }
                    n+=2;
                    while(!isPrime[n])
                        n+=2;
                    j=i*n;
                }
            }
        }
        int primeNum=0;
        for(int i=1;i<=Nmax;i++){
            if(isPrime[i]==true){
                primeNum++;
            }
        }
        return primeNum;
    }
    public static void main(String[] args){
        final int Nmax=100000000;
        double startTime=System.currentTimeMillis();
        int primeNum=Prime.calculateNumber(Nmax);
        double timeSpent=(System.currentTimeMillis()-startTime)/1000;
        System.out.println("The prime numbers from 1 to "+Nmax+" is "+primeNum);
        System.out.println("Time spent : "+timeSpent+" s");
    }
}



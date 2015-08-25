package Design;

class HashFunction {
    public static int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long hash = 0;
        long prev = (long)key[key.length - 1] % HASH_SIZE;
        hash += prev;
        for(int i = key.length - 2; i >= 0; i--){
            long part;
            if(key[i] == key[i + 1]){
                part = modAtimeB(33, prev, HASH_SIZE);
            }else{
                long val = (long)key[i];
                long mod33 = modOf33PowN(key.length - i - 1, HASH_SIZE);
                part = modAtimeB(val, mod33, HASH_SIZE);
            }
            hash += part;
            prev = part;
        }
        return (int)(hash % HASH_SIZE);
    }
    
    private static long modOf33PowN(int n, int p){
    	if(n == 0){
    		return 1 % p;
    	}
        if(n == 1){
            return 33 % p;
        }
        if(n % 2 == 0){
            return modAtimeB(modOf33PowN(n / 2, p), modOf33PowN(n / 2, p), p);
        }else{
            long half = modAtimeB(modOf33PowN((n - 1) / 2, p), modOf33PowN((n - 1) / 2, p), p);
            return modAtimeB(33, half, p);
        }
    }
    
    private static long modAtimeB(long A, long B, int p){
        return ((A % p) * (B % p)) % p;
    }
    
    public static void main(String args[]){
//    	System.out.println(modOf33PowN(0, 1000));
    	char[] key = "Wrong answer or accepted?".toCharArray();
    	System.out.println(hashCode(key, 1000000007));
//    	System.out.println(Integer.MAX_VALUE);
    }
}

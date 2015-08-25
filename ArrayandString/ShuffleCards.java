package ArrayandString;

class ShuffleCards{
    public static int[] shuffle(int[] cards){
        if(cards == null || cards.length <= 1){
            return cards;
        }
        int length = cards.length;
        int right = length / 2;
        int left = 0;
        int mid = right - 1;
        int[] result = new int[length];
        int i = length - 1;
        while(left <= mid || right < length){
            if(right < length){
                result[i--] = cards[right++];
            }
            if(left <= mid){
                result[i--] = cards[left++];
            }
        }
        return result;
    }
    
    public static void main(String args[]){
    	int[] cards = {1, 2, 3, 4};
    	int[] res = shuffle(cards);
    	for(int i : res){
    		System.out.print(i + " ");
    	}
    }
}

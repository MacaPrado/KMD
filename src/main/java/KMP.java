import java.util.ArrayList;

public class KMP {

    public static int indexOf(char[] query, char[] target){
        int[] next = nextComputation2(query);
        int rec = 0;
        int pquery = 0;
        while(rec < target.length && pquery < query.length){
            if(target[rec] == query[pquery]){
                rec++;
                pquery++;
                if(pquery == query.length){     //found!!
                    return rec-pquery;
                }
            }
            else{
                if(pquery > 0){
                    pquery = next[pquery-1];    //
                }
                else{
                    rec++;
                }
            }
        }

        return -1;
    }

    public static ArrayList<Integer> findAll(char[] query, char[] target){

        ArrayList<Integer> arr = new ArrayList<>();
        int[] next = nextComputation2(query);
        int rec = 0;
        int pquery = 0;
        while(rec < target.length && pquery < query.length){
            if(target[rec] == query[pquery]){
                rec++;
                pquery++;
                if(pquery == query.length){     //found!!
                    arr.add(rec-pquery);
                    pquery = next[pquery-1];
                }
            }
            else{
                if(pquery > 0){
                    pquery = next[pquery-1];    //
                }
                else{
                    rec++;
                }
            }
        }

        return arr;
    }

    public static int[] nextComputation2(char[] query) {
        int[] next = new int[query.length];
        next[0] = 0;     // Always. There's no proper border.
        int border = 0;  // Length of the current border
        for (int rec = 1; rec < query.length; rec++) {
            while ((border > 0) && (query[border] != query[rec]))
                border = next[border - 1];     // Improving previous computation
            if (query[border] == query[rec])
                border++;
            // else border = 0;  // redundant
            next[rec] = border;
        }
        return next;
    }

    @Deprecated
    private static int[] nextComputation(char[] query) {
        int[] next = new int[query.length];

        int border=0;  // Length of the current border

        int rec=1;
        while(rec < query.length){
            if(query[rec]!=query[border]){
                if(border!=0)
                    border=next[border-1];
                else
                    next[rec++]=0;
            }
            else{
                border++;
                next[rec]=border;
                rec++;
            }
        }
        return next;
    }

}

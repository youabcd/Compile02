public class Check {
    static char[] vt={'+','*','i','(',')','#'};
    //-1:error  0:<  1:=  2:>
    static int[][] Priority={{2,0,0,0,2,2},{2,2,0,0,2,2},{2,2,-1,-1,2,2},{0,0,0,0,1,-1},{2,2,-1,-1,2,2},{0,0,0,0,-1,-1}};
    public static int Compare(char inVt,char outVt){
        int i,j;
        for(i=0;i<6;i++){
            if(vt[i]==inVt){
                break;
            }
        }
        for(j=0;j<6;j++){
            if(vt[j]==outVt){
                break;
            }
        }
        return Priority[i][j];
    }
    public static boolean judge(char c){
        for(int i=0;i<6;i++){
            if(c==vt[i]){
                return true;
            }
        }
        return false;
    }
}

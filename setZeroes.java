class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> r= new HashSet<Integer>();
        Set<Integer> c= new HashSet<Integer>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                   r.add(i);
                   c.add(j);
                }
        }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(r.contains(i) || c.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}

package backtracking;

import java.util.ArrayList;

public class SudoKuSolve {    
	  
	  char size = '9';
	  int sizeSudoku = 9;
	  int sqrt = 3;
	  
	  private boolean isSafe(ArrayList<ArrayList<Character>> a, int row, int column, char num ){
	      
	    for( int  i = 0 ; i < sizeSudoku ; i++ ) {
	      if( a.get(row).get(i)  ==  num) return false;
	      if( a.get(i).get(column)  ==  num) return false;
	    }
	    
	    int boxRowStart = row -  ( row % sqrt ) ;
	    int boxColStart = column -  ( column % sqrt ) ;
	    for (int r = boxRowStart; r < boxRowStart + sqrt; r++){ 
	      for (int d = boxColStart; d < boxColStart + sqrt; d++){ 
	        if (a.get(r).get(d) ==  num) return false; 
	      } 
	    }
	    return true;
	  }
	    
	  
	  
	  private boolean solveSudoKuz(ArrayList<ArrayList<Character>> a) {
	    int emptyRow = -1;
	    int emptyCol = -1;
	    boolean isSudokuComplete = true;
	    for( int i=0 ; i< sizeSudoku ; i++ ) {
	      for( int j=0; j< sizeSudoku ; j++ ) {
	        if( a.get(i).get(j) == '.' ) {
	          emptyRow = i ;
	          emptyCol = j ;
	          isSudokuComplete = false;
	          break;
	        }
	      }
	      if(!isSudokuComplete) break;
	    }
	    
	    if(isSudokuComplete) return true; // sudoku is Completed
	    
	    for( char i = '1' ; i <= '9' ; i++ ) {
	      if( isSafe( a, emptyRow, emptyCol, i) ) {
	        a.get(emptyRow).set( emptyCol ,  i );
	        
	        if( solveSudoKuz(a) ) return true ;
	        else a.get(emptyRow).set( emptyCol ,  '.' );
	      }
	    }
	    return false;
	  }  
	    
	  public void solveSudoku(ArrayList<ArrayList<Character>> a) {
	      solveSudoKuz(a);
	  }
	}

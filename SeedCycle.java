package seed;

import java.util.Scanner;

public class SeedCycle {
	Scanner sc=new Scanner(System.in);
	  
	  
	  
	  int [][] CELL=new int[100][100];
	  int rows;
	  int columns;
	  int k=1;
	  
	  public void getsquarecell()
	  {
		  Scanner sc=new Scanner(System.in);
		     
		     System.out.println("Enter Rows of squareCell");
		      rows=sc.nextInt();
		     
		     System.out.println("Enter Column of squarecell");
		     columns=sc.nextInt();
		    
		     System.out.println( "Give the input  cell Press 1 For Live OR Press 0 For Dead" );
		     
		     for(int rowcell=0;rowcell<rows;rowcell++)
		     {
		       for(int columncell=0;columncell<columns;columncell++)
		       {
		    	   CELL[rowcell][columncell]=sc.nextInt();
		       }
		     }
	  }
	  
	  public void printcell()
	  {
	    for(int i=0;i<rows;i++)
	    {  
	      for(int j=0;j<columns;j++)
	      {
	    	   System.out.print(CELL[i][j]);
	      }
	       System.out.println();
	    }
	    System.out.println();
	  }
	  
	    public void cellStates() 
	    {
	      int n;
	     
	     do {
	    	 	System.out.println(" Enter Your Choice Among Following :");
	    	 	System.out.println("\t\t1. Find Next Generation ");
	        	System.out.println("\t\t2. Find the  Cell Status DEAD or ALIVE");
	        	System.out.println("\t\t3. Exit the CELL ");
	        	System.out.println("your choice is:");
	        System.out.print("\t\t");
	        int ch=sc.nextInt();
	        
	        switch(ch)
	        {
	        case 1:livecellneighbour();
	               print();
	        break;
	        case 2:livecellneighbour();
	               PrintnewCell();
	               
	        break;
	        case 3:System.exit(0);
	        
	        break;
	        }
	        System.out.print("\t\tDo u want to continue press 1 oterwise 0 = ");
	         n=sc.nextInt();
	        }while(n!=0);
	    
	    }
	  
	  
	     public void  livecellneighbour()
	     {
	           for (int i = 0; i < rows; i++)
	          {
	                     for (int j = 0; j < columns; j++)
	                   {
	                      int Cell = CELL[i][j];
	                      	newState(i,j,Cell);
	                      
	                  }
	            }

	             
	     }
	     
	     public void newState(int i,int j,int Cell) 
	     {
	                int livecellcount=0;
	        
	                 if (i - 1 >= 0 && CELL[i-1][j]==1)
	                   livecellcount++; 
	                 
	                 if(i + 1 <rows && CELL[i + 1][j]==1)
	              
	                	 livecellcount++;
	                
	              
	              
	              
	              if(j - 1 >=0 && CELL[i][j - 1]==1)
	              {
	            	  livecellcount++;
	                
	              }
	              
	              if(j + 1 <columns && CELL[i][j + 1]==1)
	              {
	            	  livecellcount++;
	                
	              }
	              
	            
	              if(j>=0 && j<columns-1 && i>=0 && i<rows-1)
	              {  
	                 if(CELL[i + 1][j + 1]==1)
	                	 livecellcount++;
	                     
	                  
	              }
	              
	             
	              if(i>0 && i<rows && j>0 && j<columns)
	              {
	                if(CELL[i - 1][j - 1]==1)
	                	livecellcount++;
	                    
	                  
	              }
	              
	              
	              if(j>0 && j<columns && i>=0 && i<rows-1)
	              {
	                if(CELL[i + 1][j - 1]==1)
	                	livecellcount++;
	                    
	                  
	              }
	              
	             
	              if(i>0 && i<rows && j>=0 && j<columns-1)
	              {
	                if(CELL[i - 1][j + 1]==1)
	                	livecellcount++;
	                  
	              }
	              
	              if(Cell==1)
	              {  
	              if(livecellcount<2)
	                CELL[i][j]=0;
	              
	              if(livecellcount>3)
	                CELL[i][j]=0;
	              
	              if(livecellcount==2|| livecellcount==3)
	              {
	                CELL[i][j]=CELL[i][j];
	              }
	              }
	              
	              if(Cell==0)
	              {
	                if(livecellcount==3)
	                CELL[i][j]=1;
	              }

	}
	     
	   public void print()
	   {
	     
	         if(k<rows)
	         System.out.println("State :"+k++);
	     
	       for(int i=0;i<rows;i++)
	       {   
	        
	         for(int j=0;j<columns;j++)
	           System.out.print("\t\t\t"+CELL[i][j]);
	         
	         System.out.println();
	       }
	       
	     }
	      
	   
	   public void PrintnewCell()
	    {
	        int counte = 0;
	      System.out.println("Enter The Cell Which You Want To Check ");
	      System.out.println("Enter Row");
	      int r=sc.nextInt();
	      System.out.println("Enter Column");
	      int c=sc.nextInt();
	      if(r<rows && c<columns)
	      {  
	      for(int i=0;i<rows;i++)
	      {
	        for(int j=0;j<columns;j++)
	          if(CELL[r][c]==0)
	            counte=0;
	          else
	            counte=1;
	      }  
	        if(counte==0)
	          System.out.print("cell status is Dead");
	        if(counte==1)
	          System.out.print("cell status is Live");
	            
	      }
	      else
	      {
	        System.out.println("Plz Enter Correct Rows And Column");
	        PrintnewCell();
	      }
	      
	    }

	  
	  
	  
	  

	  public static void main(String[] args) {
	    
	    
	     
	     
	     SeedCycle obj=new SeedCycle();
	     obj.getsquarecell();
	     obj.printcell();
	     obj.cellStates();
	     

	  }
}

/**
Project 2- Graph data Structure
Date created: 05/13/2011
Author: Calvin Kwan
**/
import java.util.Scanner;
import java.io.*;

public class Digraph
{
	final int SIZE = 21;
	final int CONNECT = 100;
	Vertex city [] = new Vertex[SIZE];
	int [][] edge = new int[CONNECT][3];
	
	int CostMatrix[][] = new int [SIZE][SIZE];
	int AdjMatrix[][] = new int [SIZE][SIZE];
	int TransMatrix[][] = new int [SIZE][SIZE];
	int MinCostMatrix[][] = new int[SIZE][SIZE];
	int pred[][] = new int[SIZE][SIZE];	
	
	public void readCity() throws IOException //inserts cities into Object list
	{
		int idx;
		String cde;
		String nam;
		int pop;
		int elv;
		
         File myFile1 = new File ("city.dat");
         Scanner inputFile1 = new Scanner(myFile1);
         
         int i = 1;
		 String line;
         while (inputFile1.hasNext())
         {
            line = inputFile1.nextLine();
			idx = Integer.parseInt(line.substring(0,2).trim());
			cde = line.substring(4,6);
			nam = line.substring(10,24);
			pop = Integer.parseInt(line.substring(27,37).trim());
			elv = Integer.parseInt(line.substring(40,44).trim());
			city[i] = new Vertex(idx, cde, nam, pop, elv);
            i++; 
         }
         inputFile1.close();	
	}

	public void readEdge() throws IOException //read the road.data
	{
		 int i = 0;
		 String line;
         File myFile2 = new File ("road.dat");
         Scanner inputFile2 = new Scanner(myFile2);		 
         while (inputFile2.hasNext())
         {
			line = inputFile2.nextLine();
			edge[i][0] = Integer.parseInt(line.substring(0,2).trim());
			edge[i][1] = Integer.parseInt(line.substring(4,6).trim());
			edge[i][2] = Integer.parseInt(line.substring(7).trim());
			i++;
		 }
		 inputFile2.close();
	}
	
    public void read() throws IOException
    {
		readCity();
		readEdge();
	}
	
	public void insertMatrix() // inserts edges into matrices
	{
		for(int n=0; n<100; n++)
		{
			if(edge[n][2] > 0)
				AdjMatrix[edge[n][0]] [edge[n][1]] = edge[n][2];
				TransMatrix[edge[n][0]] [edge[n][1]] = 1;
		}	
	}

	public int getCityIdx(String code) // gets City Index
	{
		for(int i=1; i<SIZE; i++)
		{
			if(city[i].getCode().equals(code.toUpperCase()))
				return (city[i].getIndex());
		}	
		return 0;
	}
	
	public int getCityCode(String code) //gets City Code
	{
		for(int i=1; i<SIZE; i++)
		{
			if(city[i].getCode().equals(code.toUpperCase()))
				return (city[i].getIndex());
		}	
		return 0;
	}
	
	public void FindCityInfo(String code) //Gets city info
	{
		boolean found = false;
		for(int i=1; i<SIZE; i++)
		{
			if(city[i].getCode().equals(code.toUpperCase()))
			{
				System.out.println("City: " + city[i].getName() + " Population: " + city[i].getPop() + "  Elevation: " + city[i].getElv());
				found = true;
				break;
			}
		}
		if(!found)
			System.out.println("ERROR >>> No corresponding City Info for City Code '" + code + "'");
	}
	
	public void findPath(String from, String to) //function to find path
	{
		int fromIndex = getCityIdx(from);
		int toIndex = getCityIdx(to);
		boolean err = false;		
		boolean found = false;
		
		createMinCostMatrix();
		if(fromIndex == 0)
		{
			System.out.println("ERROR >>> No such City code '" + from + "'");
			err = true;
		}
		if(toIndex == 0)
		{
			System.out.println("ERROR >>> No such City code '" + to + "'");		
			err = true;
		}
		if(!err)
		{
			if(MinCostMatrix[fromIndex][toIndex] > 0)
				System.out.println("The path from " + from.toUpperCase() + " to " + to.toUpperCase() + " is " + MinCostMatrix[fromIndex][toIndex]);
			else
				System.out.println("There is no path from " + from.toUpperCase() + " to " + to.toUpperCase());
		}	
	}
	
	public String idxtoName(int index) //convert index to City Name
	{
		for(int i=1; i<SIZE; i++)
		{
			if(city[i].getIndex() == index)
			{
				return (city[i].getName());
			}
		}
		return null;
	}
	
	public void insertConnection(String from, String to, int distance) // inserts a connection
	{
		int fromIndex = getCityIdx(from);
		int toIndex = getCityIdx(to);
		boolean err = false;
		boolean found = false;
		
		if(fromIndex == 0) //check for city code errors
		{
			System.out.println("ERROR >>> No such City code '" + from + "'");
			err = true;
		}
		if(toIndex == 0)
		{
			System.out.println("ERROR >>> No such City code '" + to + "'");		
			err = true;
		}
		if(!err)
		{
			for(int i=0; i<100; i++)
			{
				if(edge[i][0] == fromIndex && edge[i][1] == toIndex)
				{
					System.out.println("ERROR >>> The suggested edge has already existed in the system!");
					found = true;
				}	
			}
			if(!found) //if not found, then add the edge to the system
			{
				for(int j=0; j<100; j++)
				{
					if(edge[j][0] == 0 && edge[j][1] == 0)
					{
						edge[j][0] = fromIndex;
						edge[j][1] = toIndex;
						edge[j][2] = distance;
						System.out.println("The suggested edge is added successfully.");
						break;
					}
				}
			}
		}
	}
	
	public void deleteConnection(String from, String to) //deletes a connection
	{
		int fromIndex = getCityIdx(from);
		int toIndex = getCityIdx(to);
		boolean err = false;		
		boolean found = false;

		if(fromIndex == 0)
		{
			System.out.println("ERROR >>> No such City code '" + from + "'");
			err = true;
		}
		if(toIndex == 0)
		{
			System.out.println("ERROR >>> No such City code '" + to + "'");		
			err = true;
		}
		if(!err)
		{
			for(int i=0; i<100; i++)
			{
				if(edge[i][0] == fromIndex && edge[i][1] == toIndex)
				{
					edge[i][0] = 0;
					edge[i][1] = 0;
					edge[i][2] = 0;
					System.out.println("The suggested edge is removed sucessfully.");
					found = true;
				}
			}
			if(!found)
				System.out.println("ERROR >>> The suggested edge does not exist in the system!");
		}	
	}

	public void listCityData() //Lists the City Data
	{
		for(int i=1; i<SIZE; i++)
		{
			System.out.println(city[i].getIndex() + " City Code: " + city[i].getCode() + " City: " + city[i].getName() + " Population: " + city[i].getPop() + "  Elevation: " + city[i].getElv());
		}
	}

	public void outputTrans()
	{
		System.out.print("  C");
		for(int n=1; n <SIZE; n++)
		{
			System.out.format("%3d", n);
		}
		for(int i=1; i<SIZE; i++)
		{
			System.out.println();
			System.out.format("%3d", i);			
			for(int  j=1; j<SIZE; j++)
			{

				System.out.format("%3d", (CostMatrix[i][j]>0 ? 1:0));
			}
		}			
	}

	public void outputCostMatrix() // outputs the CostMatrix
	{
		System.out.println("\nMinimum Cost Matrix is: ");
		for(int i=1; i<SIZE; i++)
		{
			System.out.println();
			for(int  j=1; j<SIZE; j++)
				System.out.format("%4d", CostMatrix[i][j]);
		}
	}
	public void outputAdjMatrix() //outputs Adjacent Matrix
	{
		initializeMatrix();
		System.out.println("\nAdjacent Weighted Matrix is: ");
		for(int i=1; i<SIZE; i++)
		{
			System.out.println();
			for(int  j=1; j<SIZE; j++)
				System.out.format("%4d", AdjMatrix[i][j]);
		}
	}
	public void outputTransMatrix() //outputs Transitive Matrix
	{
		initializeMatrix();
		System.out.println("\n\nTransitive Matrices are: ");	
		int i, j, k;
		for(i=1; i<SIZE; i++)
			for(j=1; j<SIZE; j++)
				CostMatrix[i][j] = AdjMatrix[i][j];
		System.out.println("(T0) Adjacent is: ");
		outputTrans();
		
		for(k=1; k<SIZE; k++)
		{
			System.out.println("\n\nT" + k + " is: ");
			outputTrans();
			for(i=1; i<SIZE; i++)
			{
				for(j=1; j<SIZE; j++)
				{
				/* If i and j are different nodes and if
					the paths between i and k and between
					k and j exist, do */
					if ((CostMatrix[i][k] * CostMatrix[k][j] != 0) && (i != j))
						/* See if you can't get a shorter path
						between i and j by interspacing
						k somewhere along the current
						path */
						if(CostMatrix[i][k] + CostMatrix[k][j] < CostMatrix[i][j] || (CostMatrix[i][j] == 0))
						{
							CostMatrix[i][j] = CostMatrix[i][k] + CostMatrix[k][j];
						}
				}
			}
		}	
	}

	public void initializeMatrix() //intialize all Matrices to zero
	{		
		for(int i=1; i<SIZE; i++)
			for(int j=1; j<SIZE; j++)
			{
				AdjMatrix[i][j] = 0;
				TransMatrix[i][j] = 0;
				CostMatrix[i][j] = 0;
				MinCostMatrix[i][j] = 0;
			}
		insertMatrix();	
	}
		
	public void createMinCostMatrix() //Wallshall's Algorithm to find the shortest path
	{
		initializeMatrix();
		int i, j, k;
		for(i=1; i<SIZE; i++)
			for(j=1; j<SIZE; j++)
				MinCostMatrix[i][j] = AdjMatrix[i][j];
		
		for(k=1; k<SIZE; k++)
		{
			for(i=1; i<SIZE; i++)
			{
				for(j=1; j<SIZE; j++)
				{
				/* If i and j are different nodes and if
					the paths between i and k and between
					k and j exist, do */
					if ((MinCostMatrix[i][k] * MinCostMatrix[k][j] != 0) && (i != j))
						/* See if you can't get a shorter path
						between i and j by interspacing
						k somewhere along the current
						path */
						if(MinCostMatrix[i][k] + MinCostMatrix[k][j] < MinCostMatrix[i][j] || (MinCostMatrix[i][j] == 0))
						{
							MinCostMatrix[i][j] = MinCostMatrix[i][k] + MinCostMatrix[k][j];
						}
				}
			}
		}
    }

 	public void listCityConnections() //This lists the connection from the cities (Extra Credit)?
	{
		System.out.println("\nList of cities accessible from cities 1 to 10 >");
		for(int i= 1; i < 11; i++)
		{
			System.out.println("\n\n" + city[i].getName().trim() + " can access to the following cities: "); 
			for(int j =1; j<SIZE; j++)
			{
				if(CostMatrix[i][j] > 0)
					System.out.print(city[j].getName().trim() + "; ");
			}
		}
	}
}
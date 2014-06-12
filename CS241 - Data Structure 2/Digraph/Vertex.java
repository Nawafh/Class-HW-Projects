/**
Project 2- Graph data Structure
Date created: 05/13/2011
Author: Calvin Kwan
**/
public class Vertex
{
	int index;
	String code;
	String name;
	int elevation;	
	int population;	
	Edge first;
	public Vertex()
	{
		index = 0;
		code = " ";
		name = " ";
		population = 0;
		elevation = 0;
	}
	public Vertex(int ix, String cd, String nm, int pop, int elv)
	{
		index = ix;
		code = cd;
		name = nm;
		population = pop;		
		elevation = elv;

	}
	public int getIndex()
	{
		return this.index;
	}
	public String getCode()
	{
		return this.code;
	}
	public String getName()
	{
		return this.name;
	}
	public int getPop()
	{
		return this.population;
	}	
	public int getElv()
	{
		return this.elevation;
	}

}
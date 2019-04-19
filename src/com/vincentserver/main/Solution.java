package com.vincentserver.main;

import java.util.LinkedList;

class Solution {
	private class V {	
		V(int a,int b)
		{
			x = a;
			y = b;
		}
		int x;
		int y;
	}
    public int numIslands(char[][] grid) {
    	int totalIslands = 0;
    	boolean visited[][] = new boolean[grid.length][grid[0].length];
    	LinkedList<V> queue = new LinkedList<V>(); 
    	int x = 0,y = 0;
    	while(x < grid.length && y < grid[x].length)
    	{
    		if(visited[x][y] == false)
    		{
        		visited[x][y] = true;
        		if(grid[x][y] == 1)
        		{
        			totalIslands++;
        			queue.add(new V(x,y));
        	    	while (queue.size() != 0) 
        	    	{
        	    		V vertex = queue.poll();
        	    		if(vertex.x-1 >= 0 && visited[vertex.x-1][vertex.y] != true && grid[vertex.x-1][vertex.y] == 1)
        	    		{
        	    			visited[vertex.x-1][vertex.y] = true;
        	    			queue.add(new V(vertex.x-1,vertex.y));
        	    		}
        	    		if(vertex.x+1 < grid.length && visited[vertex.x+1][vertex.y] != true && grid[vertex.x+1][vertex.y] == 1)
        	    		{
        	    			visited[vertex.x+1][vertex.y] = true;
        	    			queue.add(new V(vertex.x+1,vertex.y));
        	    		}
        	    		if(vertex.y-1 > 0 && visited[vertex.x][vertex.y-1] != true && grid[vertex.x][vertex.y-1] == 1)
        	    		{
        	    			visited[vertex.x][vertex.y-1] = true;
        	    			queue.add(new V(vertex.x,vertex.y-1));
        	    		}
        	    		if(vertex.y+1 < grid[0].length && visited[vertex.x][vertex.y-1] != true && grid[vertex.x][vertex.y-1] == 1)
        	    		{
        	    			visited[vertex.x][vertex.y-1] = true;
        	    			queue.add(new V(vertex.x,vertex.y+1));
        	    		}
        	    	}
        		}
    		}
    	}
    		
		return totalIslands;      
    }
}
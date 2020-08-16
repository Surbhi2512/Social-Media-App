/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graphs {
    static HashMap<Integer,User> hm=new HashMap<>();
    
    static void addNode(ArrayList<ArrayList<User> > adj,String name, String edu, Duration dur,String hobby)
    {
        ArrayList<User> list=new ArrayList<>();
        User us=new User(name,edu,dur,hobby);
        list.add(us);
        adj.add(list);
        System.out.println(adj);
        System.out.println();
        System.out.println();
    }
    
    static void deleteNode(ArrayList<ArrayList<User> > adj,int node)
    {
        User us=adj.get(node).get(0);
        adj.remove(node);
        
        for(int i=0;i<adj.size();i++)
        {
            ArrayList<User> list=adj.get(i);
            for(int j=0;j<list.size();j++)
            {
                if(us==list.get(j))
                {
                    list.remove(us);
                }
            }
        }
        
        System.out.println();
        System.out.println();
    }
    
    static void search(ArrayList<ArrayList<User> > adj, String str)
    {
        for(int i=0;i<adj.size();i++)
        {
            ArrayList<User> list=adj.get(i);
            if(list.get(0).name.equals(str))
            {
                System.out.println(list.get(0)+ " -> " + "index= " + i);
            }
        }
        System.out.println();
        System.out.println();
    }
    
    
    
    static void addEdge(ArrayList<ArrayList<User> > adj,int e1,int e2)
    {
        User u1=adj.get(e1).get(0);
        User u2=adj.get(e2).get(0);
        
        adj.get(e1).add(u2);
        adj.get(e2).add(u1);
    }
    
    
     static void removeEdge(ArrayList<ArrayList<User> > adj,int e1,int e2)
    {
        User u1=adj.get(e1).get(0);
        User u2=adj.get(e2).get(0);
        
        adj.get(e1).remove(u2);
        adj.get(e2).remove(u1);
    }
    //waste method,delete later
    
    /*static void addMap(User a[])
    {
        for(int i=0;i<5;i++)
        {
            hm.put(i,a[i]);
        }
    }
    */
    static void printNetwork(ArrayList<ArrayList<User> > adj)
    {
        for(int i=0;i<adj.size();i++)
        {
            ArrayList<User> list=adj.get(i);
            System.out.println(list.get(0));
        }
    }
    
    static HashMap<User,Integer> addToMap(ArrayList<ArrayList<User> > adj)
    {
        HashMap<User,Integer> map=new HashMap<>();
        for(int i=0;i<adj.size();i++)
        {
            ArrayList<User> list=adj.get(i);
            User us=list.get(0);
            map.put(us, i);
        }
        return map;
    }
    
    static void Bfs1(ArrayList<ArrayList<User> > adj,String edu,Duration dur)
    {
        HashMap<User,Integer> map=addToMap(adj);
        ArrayList<User> past=new ArrayList<>();
        ArrayList<User> present=new ArrayList<>();
        
        int n=adj.size();
        ArrayList<Boolean> visited=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            visited.add(i, false);
        }
        
        for(int i=0;i<n;i++)
        {
            ArrayList<User> list=adj.get(i);
            User us=list.get(0);
            int p=map.get(us);
            
            if(visited.get(p)==false)
            {
                collegeBFS(adj,visited,map,p,edu,dur,past,present);
            }
        }
        
        if(present.size()!=0)
        {
        System.out.println("Present college mates:");
        
        for(int i=0;i<present.size();i++)
        {
            User us=present.get(i);
            System.out.println(us.name+ "  " + us.dur);
        }
        }
        System.out.println();
        System.out.println();
        
        System.out.println("Past college mates:");
        for(int i=0;i<past.size();i++)
        {
            User us=past.get(i);
            System.out.println(us.name+ "  " + us.dur);
        }
        System.out.println();
        System.out.println();
    }
    
    static void collegeBFS(ArrayList<ArrayList<User> > adj,ArrayList<Boolean> visited,HashMap<User,Integer> map,int s,
            String str,Duration dur,ArrayList<User> past,ArrayList<User> present)
    {
        Queue<Integer> q=new LinkedList<>();
        
        q.add(s);
        visited.set(s, true);
                                                                                       // 2017-2021
        while(!q.isEmpty())                                                             //2015-2019
        {                                                                               //2019-2023    
            int p=q.remove();                                                           //2013-2017                                                 
            User u=adj.get(p).get(0);
            if((u.edu).equals(str))
            {
                if(dur.eyear<=2020)
                {
                    if(u.dur.syear <= dur.eyear)
                    {
                        past.add(u);
                    }
                }
                else
                {
                    if(u.dur.eyear <= dur.syear)
                    {
                        past.add(u);
                    }
                    else
                    {
                        if(u.dur.eyear<=2020)
                        {
                            past.add(u);
                        }
                        else
                        {
                            present.add(u);
                        }
                    }
                }
            } 
            
            for(int i=0;i<adj.get(s).size();i++)
            {
                User u2=adj.get(s).get(i);
                int k=map.get(u2);
                if(visited.get(k)==false)
                {
                    q.add(k);
                    visited.set(k,true);
                }
            }
        }
    }
    
    
    
    static void Bfs2(ArrayList<ArrayList<User> > adj,String hob)
    {
        HashMap<User,Integer> map=addToMap(adj);
        
        int n=adj.size();
        ArrayList<Boolean> visited=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            visited.add(i, false);
        }
        
        for(int i=0;i<n;i++)
        {
            ArrayList<User> list=adj.get(i);
            User us=list.get(0);
            int p=map.get(us);
            
            if(visited.get(p)==false)
            {
                hobbyBFS(adj,visited,map,p,hob);
            }
        }
      
        System.out.println();
        System.out.println();
    }
    
    static void hobbyBFS(ArrayList<ArrayList<User> > adj,ArrayList<Boolean> visited,HashMap<User,Integer> map,int s,
            String str)
    {
        Queue<Integer> q=new LinkedList<>();
        
        q.add(s);
        visited.set(s, true);
                                                                                       // 2017-2021
        while(!q.isEmpty())                                                             //2015-2019
        {                                                                               //2019-2023    
            int p=q.remove();                                                           //2013-2017                                                 
            User u=adj.get(p).get(0);
            if((u.hobby).equals(str))
            {
                System.out.println(u);
            } 
            
            for(int i=0;i<adj.get(s).size();i++)
            {
                User u2=adj.get(s).get(i);
                int k=map.get(u2);
                if(visited.get(k)==false)
                {
                    q.add(k);
                    visited.set(k,true);
                }
            }
        }
    }
    
    
    static void degreeBFS(ArrayList<ArrayList<User> > adj,int s)
    {
        
        HashMap<User,Integer> map=addToMap(adj);
        
        int n=adj.size();
        ArrayList<Boolean> visited=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            visited.add(i, false);
        }
        
        int c=0;
        Queue<Integer> q=new LinkedList<>();
        
        q.add(s);
        q.add(-1);
        visited.set(s, true);
        
        if(adj.get(s).size()==1)
        {
            System.out.println("No Connections yet");
        }
        
        while(!q.isEmpty())                                                             
        {                                                                                 
            int p=q.remove();   
            
            if(p==-1)
            {
                if(!q.isEmpty())
                {
                    q.add(-1);
                    System.out.println();
                    c++;
                    System.out.println("Degree "+ c + " Connections");
                }
            }
                                 
            else{
                
            if(c>=1)
            {
                User us=adj.get(p).get(0);
                System.out.println(us.name +" " + us.edu);
            }
            
                
            for(int i=0;i<adj.get(p).size();i++)
            {
                User u2=adj.get(p).get(i);
                int k=map.get(u2);
                if(visited.get(k)==false)
                {
                    q.add(k);
                    visited.set(k,true);
                }
            }
            }
        }
    }
    
    
    static void printlist(ArrayList<ArrayList<User> > adj)
    {
        for(int i=0;i<adj.size();i++)
        {
            ArrayList<User> list=adj.get(i);
            System.out.print(list.get(0));
            
            if(list.size()>1)
            {
                for(int j=1;j<list.size();j++)
                {
                    System.out.print(" --> " + list.get(j));
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    
    
    static int[][] listtomatrix(ArrayList<ArrayList<User> > adj)
    {
        int V=adj.size();
        int a[][]=new int[V][V];
        HashMap<User,Integer> map=Graphs.addToMap(adj);
        
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                a[i][j]=-1;
            }
        }
        
        for(int i=0;i<adj.size();i++)
        {
            ArrayList<User> list=adj.get(i);
            
            if(list.size()>1)
            {
                for(int j=1;j<adj.get(i).size();j++)
                {
                    User u=list.get(j);
                    int k=map.get(u);
                    a[i][k]=i;
                    a[k][i]=k;
                }
            }
        }
        return a;
    }
    
    static void displaymatrix(ArrayList<ArrayList<User> > adj)
    {
        int a[][]=listtomatrix(adj);
        
        printmatrix(a);
    }
    
    static void printmatrix(int a[][])
    {
        int V=a.length;
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(a[i][j]==Integer.MAX_VALUE)
                {
                    System.out.print("INF ");
                }
                else
                {
                System.out.print(a[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    
    static void shortestpath(ArrayList<ArrayList<User> > adj,int n1,int n2)
    {
        int V=adj.size();
        int path[][]=listtomatrix(adj);
        
        for (int k = 0; k < V; k++) 
        { 
            for (int i = 0; i < V; i++) 
            { 
                for (int j = 0; j < V; j++) 
                { 
                    if (path[i][k]!=-1 && path[k][j]!=-1) 
                    {
                        path[i][j]=path[k][j];
                    }
                } 
            } 
        }
        
        
        System.out.print("Path:- ");
        Stack<Integer> st=new Stack<>();
        StringBuffer sb=new StringBuffer();
        sb.append(adj.get(n1).get(0).name);
        int c=n2;
        if(path[n1][n2]==n1)
        {
            sb.append("-> ").append(adj.get(n2).get(0).name);
        }
        else if(path[n1][n2]==-1)
        {
            System.out.println("No path found");
        }
        else
        {
            while(path[n1][n2]!=n1)
            {
                st.push(path[n1][n2]);
                n2=path[n1][n2];
            }
        }
     
        while(!st.isEmpty())
        {
            sb.append("-> ").append(adj.get(st.pop()).get(0).name);
        }
        
        sb.append("-> ").append(adj.get(c).get(0).name);
        System.out.println(sb);
        System.out.println();
    }
    
    }


    


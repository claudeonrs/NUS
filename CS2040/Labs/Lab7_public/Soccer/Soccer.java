/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */
import java.util.*;
import java.io.*;

public class Soccer {
  class AVLTree<Key extends Comparable<Key>, Value> {
    private Node root;
  
    private class Node {
      private final Key key;
      private Value val;
      private int height;
      private int size;
      private Node left;
      private Node right;
  
      public Node(Key key, Value val, int height, int size) {
        this.key = key;
        this.val = val;
        this.size = size;
        this.height = height;
      }
    }

    public int rank(Key key) {
      return rank(root, key);
    }
    public int rank(Node node, Key key) {
      // if key is same as node, rank(right) + 1
      if (node == null) {return 0;}
      if (node.key.compareTo(key) == 0) {
        return size(node.right) + 1;
      } else if (node.key.compareTo(key) < 0) { //if key > node.key
        return rank(node.right, key);
      } else {
        return size(node.right) + 1 + rank(node.left, key);
      }
    }
  
    public int size() {
      return size(root);
    }
  
    private int size(Node x) {
      if (x == null)
        return 0;
      return x.size;
    }
  
    private int height(Node x) {
      if (x == null)
        return -1;
      return x.height;
    }
  
    public Value get(Key key) {
      Node x = get(root, key);
      if (x == null)
        return null;
      return x.val;
    }
  
    private Node get(Node x, Key key) {
      if (x == null)
        return null;
      int cmp = key.compareTo(x.key);
      if (cmp < 0)
        return get(x.left, key);
      else if (cmp > 0)
        return get(x.right, key);
      else
        return x;
    }
  
    public boolean contains(Key key) {
      return get(key) != null;
    }
  
    public void put(Key key, Value val) {
      if (val == null) {
        delete(key);
        return;
      }
      root = put(root, key, val);
    }
  
    private Node put(Node x, Key key, Value val) {
      if (x == null)
        return new Node(key, val, 0, 1);
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        x.left = put(x.left, key, val);
      } else if (cmp > 0) {
        x.right = put(x.right, key, val);
      } else {
        x.val = val;
        return x;
      }
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      return balance(x);
    }
  
    private Node balance(Node x) {
      if (balanceFactor(x) < -1) {
        if (balanceFactor(x.right) > 0) {
          x.right = rotateRight(x.right);
        }
        x = rotateLeft(x);
      } else if (balanceFactor(x) > 1) {
        if (balanceFactor(x.left) < 0) {
          x.left = rotateLeft(x.left);
        }
        x = rotateRight(x);
      }
      return x;
    }
  
    private int balanceFactor(Node x) {
      return height(x.left) - height(x.right);
    }
  
    private Node rotateRight(Node x) {
      Node y = x.left;
      x.left = y.right;
      y.right = x;
      y.size = x.size;
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      y.height = 1 + Math.max(height(y.left), height(y.right));
      return y;
    }
  
    private Node rotateLeft(Node x) {
      Node y = x.right;
      x.right = y.left;
      y.left = x;
      y.size = x.size;
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      y.height = 1 + Math.max(height(y.left), height(y.right));
      return y;
    }
  
    public void delete(Key key) {
      if (!contains(key))
        return;
      root = delete(root, key);
    }
  
    private Node delete(Node x, Key key) {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        x.left = delete(x.left, key);
      } else if (cmp > 0) {
        x.right = delete(x.right, key);
      } else {
        if (x.left == null) {
          return x.right;
        } else if (x.right == null) {
          return x.left;
        } else {
          Node y = x;
          x = min(y.right);
          x.right = deleteMin(y.right);
          x.left = y.left;
        }
      }
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      return balance(x);
    }
  
    private Node deleteMin(Node x) {
      if (x.left == null)
        return x.right;
      x.left = deleteMin(x.left);
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      return balance(x);
    }
  
    private Node min(Node x) {
      if (x.left == null)
        return x;
      return min(x.left);
    }
  }

  class Team implements Comparable<Team>{
    int id;
    long point;

    Team(int id, long point) {
      this.id = id;
      this.point = point;
    }

    public int compareTo(Team other) {
      // compare points
      if (this.point < other.point) {
        return -1;
      } else if (this.point > other.point) {
        return 1;
      }
      // compare id by order added
      if (this.id < other.id) {
        return 1;
      } else if (this.id > other.id) {
        return -1;
      }
      return 0;
    }

  }

  public static void addTeam(AVLTree tree, HashMap pointsMap, String name, int point) {

  }

  public static void matchTeams(AVLTree tree, HashMap pointsMap, String name) {

  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Soccer soccer = new Soccer();

    // to store rank and shit
    AVLTree<Team, Boolean> tree = soccer.new AVLTree<>();

    // to find team given team name
    HashMap<String, Team> map = new HashMap<>();

    int numQueries = Integer.parseInt(br.readLine());
    String[] words;
    String name;
    Long point;
    int id;
    Team team;
    
    for (int i=0; i<numQueries; i++) {
      words = br.readLine().split(" ");
      switch (words[0]) {
        case "ADD":
          name = words[1];
          point = Long.parseLong(words[2]);
          id = i;
          team = soccer.new Team(id, point);
          map.put(name, team);
          tree.put(team, true);
          break;
        case "MATCH":
          String name1 = words[1];
          String name2 = words[2];
          int goals1 = Integer.parseInt(words[3]);
          int goals2 = Integer.parseInt(words[4]);

          Team team1 = map.get(name1);
          Team team2 = map.get(name2);

          long points1 = team1.point;
          long points2 = team2.point;

          tree.delete(team1);
          tree.delete(team2);

          int diff = goals1 - goals2;
          points1 += diff;
          points2 -= diff;
          if (diff == 0) {
            break;
          }
                  
          if (points1 <= 0) {
            map.remove(name1);
            map.put(name2, team2);
            team2.point = points2;
            tree.put(team2, true);
          } else if (points2 <= 0) {
            map.remove(name2);
            map.put(name1, team1);
            team1.point = points1;
            tree.put(team1, true);
          } else {

            map.put(name1, team1);
            team1.point = points1;
            tree.put(team1, true);

            map.put(name2, team2);
            team2.point = points2;
            tree.put(team2, true);
          }
          break;
        case "QUERY":
          name = words[1];
          team = map.get(name);
          if (team == null) {
            pw.printf("Team %s is ELIMINATED\n", name);
          }
          else {
            int rank = tree.rank(team);
            pw.printf("Team %s: %d points, rank %d\n", name, team.point, rank);
          }
          break;
          
          
          
      }
    }

    pw.close();
    br.close();
  }
}

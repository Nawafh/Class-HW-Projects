/*
Calvin Kwan
CS241 - Project 3 Search Algorithms
*/
public class Hash<K,V>
{
   String K;
   String V;
   private Hashnode<K,V>[] nodes;
   
   public Hash(int size)
   {
      nodes = new Hashnode[size];
   }

   private int getIndex(K key)
   {
      int hash = key.hashCode() % nodes.length;
      if (hash < 0)
         hash += nodes.length;
      return hash;
   }

   public V insert(K key, V data)
   {
      int hash = getIndex(key);
         for (Hashnode<K,V> node = nodes[hash]; node != null; node = node.next) 
         {
            if (key.equals(node.key)) 
            {
               V oldData = node.data;
               node.data = data;
               return oldData;
            }
        }

         Hashnode<K,V> node = new Hashnode<K,V>(key, data, nodes[hash]);
         nodes[hash] = node;
         return null;
   }

   public boolean remove(K key)
   {
      int hash = getIndex(key);

      Hashnode<K,V> prevnode = null;
      for (Hashnode<K,V> node = nodes[hash]; node != null; node = node.next)
      {
         if (key.equals(node.key)) 
         {
            if (prevnode != null)
               prevnode.next = node.next;
            else
               nodes[hash] = node.next;
            return true;
         }
         prevnode = node;
      }

      return false;
   }

   public int get(K key)
   {
      int k1 = 0;
      int k2 = 0;
      
      int hash = getIndex(key);
      for (Hashnode<K,V> node = nodes[hash]; node != null; node = node.next) 
      {
         k1 = 3*k1+1;
         k2 = k2+2;
         if (key.equals(node.key))
         {
            System.out.println("(Hashing) Find: " +  node.data + " bucket index: " + key.hashCode() % nodes.length);
            //return node.data;
            return (k1+k2);
         }
      }
      System.out.println("(Hashing) Find: " +  key + " bucket index = -1"); 
      //return null;
      return (k1+k2+1);
   }
}
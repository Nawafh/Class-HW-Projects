/*
Calvin Kwan
CS241 - Project 3 Search Algorithms
*/
public class Hashnode<K, V>
{
   K key;
   V data;
   Hashnode<K,V> next;

   public Hashnode(K k, V v, Hashnode<K,V> n)
   {
      key = k; data = v; next = n; 
   }
}
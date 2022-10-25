package adt;


public class LinkedList<T>implements ListInterface<T> {

    class node{
        T data;
        node next;
    }

    node head;
    node tail;
    node next;
    int index;
    
    node create_node(T data){
        node n = new node();
        n.data = data;
        n.next = null;
        return n;
    }
    public LinkedList(){
        head = null;
        tail = null;
        index = 0;
    }

    @Override
    public void add(T newEntry){
        node newest = create_node(newEntry);
        //adding in tail is default for a singly-linked list similar to queue
        if(tail != null){
            tail.next = newest;
        }
        tail = newest;
        if(head == null){
            head = newest;
        }
        index++;
    }
    
    public void addHead(T newEntry){
        //a helper function that add a new entry at the head
        node newest = create_node(newEntry);
        newest.next = head;
        head = newest;
        if(tail == null){
            tail = newest;
        }
        index++;
    }
    
    @Override
    public int indexOf(T Entry){
        node currnode = head;
        int count = 0;
        while(currnode != null){
            if(currnode.equals(Entry)){
                return count;
            }
            else{
                currnode = currnode.next;
                count++;
            }    
        }
        return 0;
    }
    
    @Override
    public boolean remove(int givenPosition){
        node currnode = head;
        node prevnode = null;
         int count = 0;
        if(givenPosition == 1){
            if(head != null){
                head = head.next;
                if(head == null){
                    tail = null;
                }
                index--;
                return true;
            }
        }
        if(givenPosition == index + 1){
            if(tail != null){
                while(currnode != null){
                    if(currnode.next == null){
                        prevnode.next = null;
                        tail = prevnode;
                        index--;
                        return true;
                    }
                    else{
                        prevnode = currnode;
                        currnode = currnode.next;
                    }
                }
            }
            if(tail == null){
                head = null;
            }
            return false;
        }
        while(currnode != null){
            count++;
            if(givenPosition == count){
                if(prevnode != null){
                    prevnode.next = currnode.next;
                    if(currnode == tail){
                        tail = prevnode;
                    }
                    index--;
                    return true;
                }
                else if(head != null){
                    head = head.next;
                    if(head == null){
                        tail = null;
                    }
                    index--;
                    return true;
                }
            }
            else{
                prevnode = currnode;
                currnode = currnode.next;
            }
        }
        return false;
    }
  @Override  
  public boolean replace(int givenPosition, T newEntry) {
      node currnode = head;
      node newest = create_node(newEntry);
      int count = 0;
          if(givenPosition == 1){
              currnode.data = newest.data;
              return true;
          }
          if(givenPosition == index + 1){
              add(newEntry);
              return true;
          }
          while(currnode != null){
              count++;
              if(givenPosition == count){
                  currnode.data = newest.data;
                  return true;
              }
              else{
                  currnode = currnode.next;
              }
          }
      return false;
  }
    
    @Override
    public T getElement(int givenPosition){
        node currnode = head;
        int count = 0;
        while (currnode != null) {
            count++;
                if (givenPosition == count) {
                    return currnode.data;
                } else {
                    currnode = currnode.next;
                }
        }
        return currnode.data;
    }

    @Override
    public boolean clear() {
        node currnode = head;
        index = 0;
        while (currnode != null){
            next = currnode.next;
            currnode = next;
            head = null;
            tail = null;
            return true;
        }
    return false;
    }
    
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public int size(){
        return index;
    }
    
}
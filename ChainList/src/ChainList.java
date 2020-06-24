interface ILink<E> {
    public void add(E e);
    public int size();
    public boolean isEmpty();
    public Object [] toArray();
    public E get(int index);
    public void set(int index, E data);
    public boolean contains(E data);
    public void remove(E data);
    public void clean();
}

class LinkImpl<E> implements ILink<E>{
    private class Node{//保存数据间的结构关系
        private E data;
        private Node next;
        public Node(E data){
            this.data = data;
        }
        public void addNode(Node newNode){
            if(this.next == null){
                this.next = newNode;
            }
            else{
                this.next.addNode(newNode);
            }

        }
        public void toArrayNode(){
            LinkImpl.this.returnData[LinkImpl.this.foot++] = this.data;
            if(this.next != null){
                this.next.toArrayNode();
            }
        }
        public E getNode(int index){
            if(LinkImpl.this.foot++ == index){
                return this.data;
            }
            else{
                return this.next.getNode(index);
            }
        }
        public void setNode(int index, E data){
            if(LinkImpl.this.foot ++ == index){
                this.data = data;
            }
            else{
                this.next.setNode(index,data);
            }
        }
        public boolean containsNode(E data){
            if(data.equals(this.data)){
                return true;
            }
            else{
                if(this.next == null){
                    return false;
                }
                return this.next.containsNode(data);
            }
        }
        public void removeNode(Node previous, E data){
            if(this.data.equals(data)){
                previous.next = this.next;
            }
            else{
                if(this.next != null){
                    this.next.removeNode(this,data);
                }
            }
        }
    }
    private Node root;
    private int count;
    private int foot;
    private Object [] returnData;
    public void add(E e){ //数据本身不具有关联性，需要将其包装在Node类之中
        if(e == null){
            return ;
        }
        Node newNode = new Node(e);
        if (this.root == null){
            this.root = newNode;
        }
        else{
            this.root.addNode(newNode);
        }
        this.count++;
    }
    public int size(){
        return this.count;
    }
    public boolean isEmpty(){
        //return this.root == null;
        return this.count == 0;
    }
    public Object [] toArray(){
        if(this.isEmpty()){
            return null;
        }
        this.foot = 0;
        this.returnData = new Object [this.count];
        this.root.toArrayNode();
        return this.returnData;
    }
    public E get(int index){
        if(index >= this.count){
            return null;
        }
        this.foot = 0;
        return this.root.getNode(index);
    }
    public void set(int index, E data){
        if(index >= this.count){
            return;
        }
        this.foot = 0;
        this.root.setNode(index,data);
    }
    public boolean contains(E data){
        if(data == null){
            return false;
        }
        return this.root.containsNode(data);
    }

    public void remove(E data){
        if (this.contains(data)){
            if(this.root.data.equals(data)){
                this.root = this.root.next;
            }
            else{
                this.root.next.removeNode(this.root,data);
            }
            this.count--;
        }
    }

    public void clean(){
        this.root = null;
        this.count = 0;
    }

}

interface Pet{
    public String getName();
    public String getColor();
}
class PetShop{
    private ILink<Pet> allPets = new LinkImpl<>();
    public void add(Pet pet){//追加宠物，商品上架
        this.allPets.add(pet);
    }
    public void delete(Pet pet){
        this.allPets.remove(pet);
    }
    public ILink<Pet> search(String keyWord){
        ILink<Pet> searchResult = new LinkImpl<>();
        Object [] result = this.allPets.toArray();
        if (result != null){
            for(Object obj : result){
                Pet pet = (Pet)obj;
                if(pet.getName().contains(keyWord) || pet.getColor().contains(keyWord)){
                    searchResult.add(pet);
                }

            }
        }
        return searchResult;
    }

}

class Cat implements Pet{
    private String name;
    private String color;
    public Cat(String name,String color){
        this.name = name;
        this.color = color;
    }
    public String getName(){
        return this.name;
    }
    public String getColor(){
        return this.color;
    }
    public String toString(){
        return "【宠物猫】名字: " + this.name + "、颜色： " + this.color;
    }
    public boolean equals(Object obj){
        if(obj == null ){
            return false;
        }
        if(!(obj instanceof Cat)){
              return false;
        }
        if(this == obj){
            return true;
        }
        Cat cat = (Cat)obj;
        return this.name.equals(cat.name) && this.color.equals(cat.color);
    }

}

class Dog implements Pet{
    private String name;
    private String color;
    public Dog(String name,String color){
        this.name = name;
        this.color = color;
    }
    public String getName(){
        return this.name;
    }
    public String getColor(){
        return this.color;
    }
    public String toString(){
        return "【宠物狗】名字: " + this.name + "、颜色： " + this.color;
    }
    public boolean equals(Object obj){
        if(obj == null ){
            return false;
        }
        if(!(obj instanceof Dog)){
            return false;
        }
        if(this == obj){
            return true;
        }
        Dog dog = (Dog)obj;
        return this.name.equals(dog.name) && this.color.equals(dog.color);
    }

}

public class ChainList {
    public static void main(String [] args){
        ILink<String> all = new LinkImpl<>();
        System.out.println("增加之前数据的个数：" + all.size());
        all.add("hello");
        all.add("world");
        all.remove("world");
        System.out.println("增加之后数据的个数: " + all.size());

        Object [] result = all.toArray();
        for (Object obj : result){
            System.out.println(obj);
        }

        all.add("bin zi");

        System.out.println(all.get(2));
        all.set(2,"饼子");
        System.out.println(all.get(2));
        System.out.println(all.get(3));
        System.out.println(all.contains("binzi"));
        System.out.println(all.contains("饼子"));
    }
}

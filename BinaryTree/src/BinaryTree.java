import java.util.Arrays;
public class BinaryTree {
    public static void main(String [] args){
        BinaryTrees<Person> bt = new BinaryTrees<>();
        bt.add(new Person("小强-80",80));
        bt.add(new Person("小李-50",50));
        bt.add(new Person("小张-60",60));
        bt.add(new Person("小闻-30",30));
        bt.add(new Person("小翟-90",90));
        bt.add(new Person("小刘-10",10));
        bt.add(new Person("小宁-55",55));
        bt.add(new Person("小秦-70",70));
        bt.add(new Person("小赵-85",85));
        bt.add(new Person("小王-95",95));
        //bt.remove(new Person("小刘-10",10));
        bt.remove(new Person("小闻-30",30));
        //bt.remove(new Person("小闻-30",30));
        //bt.remove(new Person("小李-50",50));
        //bt.remove(new Person("小翟-90",90));
        //bt.remove(new Person("小强-80",80));
        System.out.println(Arrays.toString(bt.toArray()));
    }
}
class BinaryTrees<T extends Comparable<T>>{
    private class Node{
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;
        public Node(Comparable<T> data){
            this.data = data;
        }
        /*
        * 实现节点数据的适当位置的存储
        * @param newNode 创建的新节点
        * */
        public void addNode(Node newNode){
            if(newNode.data.compareTo((T)this.data) <= 0){ //比当前节点数据小
                if(this.left == null){ //现在没有左子树
                    this.left = newNode;//保存左子树
                    newNode.parent = this;//保存父节点
                }else{//需要向左边继续判断
                    this.left.addNode(newNode);//继续向下判断
                }
            }else{//比根节点的数据要大
                if(this.right == null){
                    this.right = newNode;
                    newNode.parent = this;
                }else{
                    this.right.addNode(newNode);
                }

            }
        }
        /*
        * 实现所有数据的获取处理，按照中序遍历的形式来完成
        * */
        public void toArrayNode(){
            if(this.left != null){
                this.left.toArrayNode();
            }
            BinaryTrees.this.returnData[BinaryTrees.this.foot++] = this.data;
            if(this.right != null){
                this.right.toArrayNode();
            }
        }
        public boolean containsNode(Comparable<T> data){
            if(data.compareTo((T)this.data) == 0){
                return true;//查找到了
            }else if(data.compareTo((T)this.data) < 0){
                if(this.left != null){
                    return this.left.containsNode(data);
                }else{
                    return false;
                }

            }else{
                if(this.right != null){
                    return this.right.containsNode(data);
                }else{
                    return false;
                }
            }
        }
        /*
        * 获取要删除的节点对象
        * @param data 比较的对象
        * @return 要删除的节点对象，对象一定存在
        * */
        public Node getRemoveNode(Comparable<T> data){
            if(data.compareTo((T)this.data) == 0){
                return this;//查找到了
            }else if(data.compareTo((T)this.data) < 0){
                if(this.left != null){
                    return this.left.getRemoveNode(data);
                }else{
                    return null;
                }
            }else{
                if(this.right != null){
                    return this.right.getRemoveNode(data);
                }else{
                    return null;
                }
            }
        }
    }

    //------------二叉树功能实现-----------------//
    /* *
    * 进行数据的保存
    * @param data 要保存的内容
    * @exception NullPointerException保存数据为空时抛出的异常
    *  */
    private Node root;//保存的是根节点
    private int count;//保存的是数据的个数
    private Object [] returnData;//返回数据
    private int foot = 0;//角标控制
    public void add(Comparable<T> data){
        if(data == null){
            throw new NullPointerException("保存的数据不能为空！");
        }
        //所有的数据本身不具备有节点关系的匹配，那么一定要将其包装在Node类之中
        Node newNode = new Node(data);
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);//交由Node类进行处理
        }
        this.count++;
    }
    /*
    * 现在的检索主要依靠的是Comparable实现的数据比较
    * @param data 要比较的数据
    * @return 查找到数据返回true，否则返回false
    * */
    public boolean contains(Comparable<T> data){
        if(this.count == 0){
            return false;
        }
        return this.root.containsNode(data);
    }
    /**
     * 以对象数组的形式返回全部数据，如果没有数据返回null
     * @return 全部数据
     */
    public Object [] toArray(){
        if(this.count == 0){
            return null;
        }
        this.returnData = new Object[this.count];
        this.foot = 0;//角标清0
        this.root.toArrayNode();//直接通过Node类负责
        return this.returnData;//返回全部的数据
    }
    /*
    * 执行数据的删除处理
    * */
    public void remove(Comparable<T> data){
            if(this.root == null){
                return;
            }else{
                if(this.root.data.compareTo((T)data) == 0){
                    Node moveNodeRoot = this.root.right;
                    while(moveNodeRoot.left != null){//还有左边的节点
                        moveNodeRoot = moveNodeRoot.left;//一直向左边找
                    }//就可以确定删除节点的右节点的最小的左节点
                    moveNodeRoot.left = this.root.left;
                    moveNodeRoot.right = this.root.right;
                    moveNodeRoot.parent.left = null;
                    this.root = moveNodeRoot;

                }else{
                    //找到要删除的节点
                    Node removeNode = this.root.getRemoveNode(data);
                    if(removeNode != null){
                        //情况一，左右子树都为空
                        if(removeNode.left == null && removeNode.right == null){
                            removeNode.parent.left = null;
                            removeNode.parent.right = null;
                            removeNode.parent = null;
                        }else if(removeNode.left != null && removeNode.right == null){
                            removeNode.parent.left = removeNode.left;
                            removeNode.left.parent = removeNode.parent;
                        }else if(removeNode.left == null && removeNode.right != null){
                            removeNode.parent.left = removeNode.right;
                            removeNode.right.parent = removeNode.parent;
                        }else{//两边都有节点，则将左边节点中最左边的节点找到，改变其指向
                            Node moveNode = removeNode.right;
                            while(moveNode.left != null){//还有左边的节点
                                moveNode = moveNode.left;//一直向左边找
                            }//就可以确定删除节点的右节点的最小的左节点
                            removeNode.parent.left = moveNode;
                            moveNode.parent.left = null;//断开原本的链接
                            moveNode.parent = removeNode.parent;
                            moveNode.right = removeNode.right;//改变原始的右节点的指向
                            moveNode.left = removeNode.left;
                            //removeNode.right.parent = moveNode;
                        }

                    }

                }
                this.count--;
            }
    }
}
class Person implements Comparable<Person>{
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Person per) {
        return this.age - per.age;
    }
    @Override
    public String toString(){
        return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n";
    }
}


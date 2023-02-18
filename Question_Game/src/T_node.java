public class T_node {
    public T_node t_side;//left node
    public T_node f_side;// right node of the tree

    public String Name;
    //Constructor Where both Nodes of Quiz_Tree are set non-null
    public T_node(String Test,T_node t,T_node f){
        this.Name=Test;
        this.t_side=t;
        this.f_side=f;


    }

    //Constructor Where both Nodes of Quiz_Tree are set  to null
    public T_node(String choice){
        this.Name=choice;
        this.t_side=null;
        this.f_side= null;


    }

}

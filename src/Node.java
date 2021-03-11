import java.util.Set;
import java.util.TreeSet;

public class Node implements Comparable<Node> {

    private int Id;
    private String MenuName;
    private int ParentId;
    private boolean isHidden;
    private String LinkURL;
    private Set<Node> childrenItems;

    public Node() {

        Id = 0;
        childrenItems = new TreeSet<>();

    }

    public Node(int id, String menuName, int parentId, boolean isHidden, String linkURL) {
        this.Id = id;
        this.MenuName = menuName;
        this.ParentId = parentId;
        this.isHidden = isHidden;
        this.LinkURL = linkURL;
        childrenItems = new TreeSet<>();
    }

    public void addChild(Node node) {
        childrenItems.add(node);
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        this.MenuName = menuName;
    }

    public int getParentId() {
        return ParentId;
    }

    public void setParentId(int parentId) {
        this.ParentId = parentId;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        this.isHidden = hidden;
    }

    public String getLinkURL() {
        return LinkURL;
    }

    public void setLinkURL(String linkURL) {
        this.LinkURL = linkURL;
    }

    public Set<Node> getChildrenItems() {
        return childrenItems;
    }

    public void setChildrenItems(Set<Node> childrenItems) {
        this.childrenItems = childrenItems;
    }

    @Override
    public String toString() {

        return "Node{" +
                "Id=" + Id +
                ", MenuName='" + MenuName + '\'' +
                ", ParentId=" + ParentId +
                ", isHidden=" + isHidden +
                ", LinkURL='" + LinkURL + '\'' +
                '}';
    }
    
  

    @Override
    public int compareTo(Node o) {
        return MenuName.compareTo(o.MenuName);
    }
}

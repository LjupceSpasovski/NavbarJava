import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Navigation {

	private static Map<Integer, Node> navMenu(String[] array, Map<Integer, Node> map) {

		for (String columns : array) {
			String[] column = columns.split(";");
			int Id = Integer.parseInt(column[0]);
			String MenuName = column[1];
			int ParentId = 0;
			if (!column[2].equals("NULL")) {
				ParentId = Integer.parseInt(column[2]);

			}
			boolean isHidden = Boolean.parseBoolean(column[3]);
			String LinkURL = column[4];

			Node node = new Node(Id, MenuName, ParentId, isHidden, LinkURL);
			map.put(node.getId(), node);
		}

		return map;
	}

	private static void printTree(Node node, Integer level) {

		if (!node.isHidden()) {
			if (node.getId() != 0) {
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < level; i++) {
					sb.append(".");
				}

				System.out.println(sb + node.getMenuName());
			}
			for (Node child : node.getChildrenItems()) {
				printTree(child, level + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		String csvFile = "Navigation.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			Map<Integer, Node> mapTmp = new HashMap<Integer, Node>();

			String s;

			br.readLine();
			while ((s = br.readLine()) != null) {
				String[] line = s.split(",");
				navMenu(line, mapTmp);
			}
			Node root = new Node();
			mapTmp.put(root.getId(), root);

			for (Integer id : mapTmp.keySet()) {
				if (id == 0) {
					continue;
				}

				Node node = mapTmp.get(id);
				int ParentId = node.getParentId();
				if (mapTmp.containsKey(ParentId)) {
					Node parentNode = mapTmp.get(ParentId);
					parentNode.addChild(node);
				}
			}
			printTree(root, 0);
			br.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}

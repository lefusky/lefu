package com.syonenet.util;

import java.util.ArrayList;
import java.util.List;

import com.syonenet.entity.NewsType;
import com.syonenet.entity.TreeMenu;
import com.syonenet.entity.TreeNode;

public class TreeBuilder {

	/**
	 * ����ѭ��ʵ�ֽ���
	 * 
	 * @param treeNodes
	 *            ��������ڵ��б�
	 * @return
	 */
	public static List<TreeNode> bulid(List<TreeNode> treeNodes) {

		List<TreeNode> trees = new ArrayList<TreeNode>();

		for (TreeNode treeNode : treeNodes) {

			if (0 == treeNode.getPid()) {
				trees.add(treeNode);
			}

			for (TreeNode it : treeNodes) {

				if (it.getPid() == treeNode.getId()) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<TreeNode>());
					}
					treeNode.getChildren().add(it);
				}

			}
		}
		return trees;
	}

	public static List<TreeNode> bulidNew(List<TreeNode> treeNodes, Integer typeId) {

		List<TreeNode> trees = new ArrayList<TreeNode>();

		for (TreeNode treeNode : treeNodes) {

			if (typeId == treeNode.getPid()) {
				trees.add(treeNode);
			}

			for (TreeNode it : treeNodes) {

				if (it.getPid() == treeNode.getId()) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<TreeNode>());
					}
					treeNode.getChildren().add(it);
				}

			}
		}
		return trees;
	}

	public static Object bulidMenu(List<TreeMenu> treeMenus, Integer typeId) {
		// TODO Auto-generated method stub

		List<TreeMenu> trees = new ArrayList<TreeMenu>();

		for (TreeMenu treeMenu : treeMenus) {

			if (typeId == treeMenu.getPid()) {
				trees.add(treeMenu);
			}

			for (TreeMenu it : treeMenus) {

				if (it.getPid() == treeMenu.getId()) {
					if (treeMenu.getSubmenu() == null) {
						treeMenu.setSubmenu(new ArrayList<TreeMenu>());
					}
					treeMenu.getSubmenu().add(it);
				}

			}
		}
		return trees;
	}

	/**
	 * ����id ��ȡ���и���Ŀ¼ һά ��;����ҳ > ������� > JAVA > hibernate >
	 * hibernate���Ž̳̣�����������һ��ϵͳ��ǰλ�� ����λ�û�ȡ�����и���
	 * 
	 * @param list
	 * @param pid
	 * @return
	 */
	public static List<NewsType> getParents(List<NewsType> newsTypeList, int pid) {
		List<NewsType> arr = new ArrayList<NewsType>();
		for (NewsType newsType : newsTypeList) {
			if (pid == newsType.getTypeId()) {
				arr.addAll(getParents(newsTypeList, newsType.getTypePid()));
				arr.add(newsType);
				break;
			}
		}
		return arr;
	}

	/**
	 * ��ȡָ�������µ������ӷ���
	 * 
	 * @param newsTypeList
	 * @param pid
	 * @return
	 */
	public static List<NewsType> getChilds(List<NewsType> newsTypeList, int pid) {
		List<NewsType> arr = new ArrayList<NewsType>();
		for (NewsType newsType : newsTypeList) {
			if (pid == newsType.getTypePid()) {
				arr.addAll(getChilds(newsTypeList, newsType.getTypeId()));
				arr.add(newsType);
			}
		}
		return arr;
	}

	/**
	 * ʹ�õݹ鷽������
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static List<TreeNode> buildByRecursive(List<TreeNode> treeNodes) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (TreeNode treeNode : treeNodes) {
			if (0 == treeNode.getPid()) {
				trees.add(findChildren(treeNode, treeNodes));
			}
		}
		return trees;
	}

	/**
	 * �ݹ�����ӽڵ�
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
		for (TreeNode it : treeNodes) {
			if (treeNode.getId().equals(it.getPid())) {
				if (treeNode.getChildren() == null) {
					treeNode.setChildren(new ArrayList<TreeNode>());
				}
				treeNode.getChildren().add(findChildren(it, treeNodes));
			}
		}
		return treeNode;
	}

}

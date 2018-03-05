package com.syonenet.util;

import java.util.ArrayList;
import java.util.List;

import com.syonenet.entity.NewsType;
import com.syonenet.entity.TreeMenu;
import com.syonenet.entity.TreeNode;

public class TreeBuilder {

	/**
	 * 两层循环实现建树
	 * 
	 * @param treeNodes
	 *            传入的树节点列表
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
	 * 根据id 获取所有父级目录 一维 用途（首页 > 编程语言 > JAVA > hibernate >
	 * hibernate入门教程）类似这样的一个系统当前位置 传入位置获取到所有父级
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
	 * 获取指定分类下的所有子分类
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
	 * 使用递归方法建树
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
	 * 递归查找子节点
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

package com.spring.springbootintegrated1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据生成树状结构工具类
 * 
 * @Description:TreeUtil
 * @author:yanglin
 * @time:2018年8月22日 下午3:25:33
 */
public class TreeUtil {

    private static List<Map<String, Object>> nodes = null;

    /**
     * <p>
     * 构建JSON树形结构<br>
     * </p>
     * 
     * @param nodesList 原始数据
     * @return List<Map<String, Object>>
     * 
     * @author:yanglin
     * @time:2019年1月24日 上午10:22:14
     */
    public static List<Map<String, Object>> buildTreeList(List<Map<String, Object>> nodesList) {
        nodes = nodesList;
        return buildTree();
    }

    /**
     * <p>
     * 构建树形结构<br>
     * </p>
     * 
     * @return List<Map<String, Object>>
     * 
     * @author:yanglin
     * @time:2019年1月24日 上午10:26:25
     */
    public static List<Map<String, Object>> buildTree() {
        List<Map<String, Object>> treeNodes = new ArrayList<>();
        List<Map<String, Object>> rootNodes = getRootNodes();
        for (Map<String, Object> rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    /**
     * <p>
     * 递归子节点，并判断是否是叶子节点<br>
     * </p>
     * 
     * @param node 子节点数据
     * 
     * @author:yanglin
     * @time:2019年1月24日 上午10:26:49
     */
    public static void buildChildNodes(Map<String, Object> node) {
        List<Map<String, Object>> children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (Map<String, Object> child : children) {
                buildChildNodes(child);
            }
            node.put("children", children);
            node.put("isLeaf", false);
        } else {
            node.put("isLeaf", true);
        }
    }

    /**
     * <p>
     * 获取父节点下所有的子节点<br>
     * </p>
     * 
     * @param pnode 父节点信息
     * @return List<Map<String, Object>>
     * 
     * @author:yanglin
     * @time:2019年1月24日 上午10:27:20
     */
    public static List<Map<String, Object>> getChildNodes(Map<String, Object> pnode) {
        List<Map<String, Object>> childNodes = new ArrayList<>();
        for (Map<String, Object> n : nodes) {
            if (pnode.get("id").toString().equals(n.get("pid").toString())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    /**
     * <p>
     * 判断是否为根节点<br>
     * </p>
     * 
     * @param node 节点信息
     * @return boolean
     * 
     * @author:yanglin
     * @time:2019年1月24日 上午10:28:14
     */
    public static boolean rootNode(Map<String, Object> node) {
        boolean isRootNode = true;
        for (Map<String, Object> n : nodes) {
            if (node.get("pid").toString().equals(n.get("id").toString())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    /**
     * <p>
     * 获取集合中所有的根节点<br>
     * </p>
     * 
     * @return List<Map<String, Object>>
     * 
     * @author:yanglin
     * @time:2019年1月24日 上午10:28:41
     */
    public static List<Map<String, Object>> getRootNodes() {
        List<Map<String, Object>> rootNodes = new ArrayList<>();
        for (Map<String, Object> n : nodes) {
            if (rootNode(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }

    /**
     * <p>
     * 判断数据中是否存在<br>
     * </p>
     * 
     * @param id       节点ID
     * @param nodelist 节点列表
     * @return boolean
     * 
     * @author:yanglin
     * @time:2019年1月24日 上午10:28:58
     */
    public static boolean hasNodes(String id, List<Map<String, Object>> nodelist) {
        for (Map<String, Object> n : nodelist) {
            if (n.get("id").toString().equals(id)) {
                return true;
            }
        }
        return false;
    }

}

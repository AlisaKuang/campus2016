package com.cmi.service;

import com.cmi.entity.CMIImportInfo;
import com.cmi.entity.CMITreeNode;

import java.util.List;

/**
 * Created by lenovo on 2016/6/5.
 */
public interface ICMIImportService {

    /**
     * ��ȡ����import�����б�
     * @param result
     * @param path
     */
    public void genImportPathIlter(List<String> result, String path);

    /**
     * ����import·����
     * @param root
     * @param result
     */
    public void genPathTree(CMITreeNode root, List<String> result);

    /**
     * ����import·����
     * @param root
     * @param path
     */
    public void genPathTree(CMITreeNode root, String path);

    /**
     * ���㱻import����ĸ���
     * @param root
     * @return
     */
    public List<CMIImportInfo> countImport(CMITreeNode root);

}

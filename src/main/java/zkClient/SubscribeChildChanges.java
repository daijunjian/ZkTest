package zkClient;

import org.I0Itec.zkclient.IZkChildListener;

import java.util.List;

/**
 *订阅节点的信息改变（创建节点，删除节点，添加子节点）
 */
public class SubscribeChildChanges implements IZkChildListener{

    public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
        System.out.println("订阅节点的信息改变（创建节点，删除节点，添加子节点）" + parentPath + "   " + currentChilds.toString());
    }

}

package zk;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * 订阅节点的数据内容的变化
 */
public class SubscribeDataChanges implements IZkDataListener{

	public void handleDataChange(String dataPath, Object data)
			throws Exception {
		System.out.println("订阅节点的数据内容的变化"+dataPath + ":" + data.toString());
	}

	public void handleDataDeleted(String dataPath) throws Exception {
		System.out.println("订阅节点的数据内容被删除" + dataPath);
	}

}

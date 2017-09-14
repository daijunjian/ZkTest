package zkClient;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.ZkClient;

public class NodeManager {

	static ZkClient zkClient = null;

	static {
		String ZKServers = "127.0.0.1:2181";
//        ZkClient zkClient = new ZkClient(ZKServers,10000,10000,new SerializableSerializer());
		zkClient = new ZkClient(ZKServers);
		zkClient.addAuthInfo("digest", "root:root@123".getBytes());
		zkClient.subscribeStateChanges(new SubscribeStateListener());
		zkClient.subscribeChildChanges("/aganNode", new SubscribeChildChanges());
		zkClient.subscribeDataChanges("/aganNode", new SubscribeDataChanges());
		System.out.println("conneted ok!");
	}

	public void createNode() {
		User user = new User();
		user.setId(1);
		user.setName("顶顶顶顶");

		String userJson = JSON.toJSONString(user);
		/**
		 * "/testUserNode" :节点的地址 user：数据的对象 CreateMode.PERSISTENT：创建的节点类型
		 */
		zkClient.createPersistent("/aganNode", userJson);
//		String path = zkClient.create("/aganNode", string, CreateMode.PERSISTENT);
		
		// 输出创建节点的路径
//		System.out.println("创建节点:" + path);
	}

	public void getNode() {
		Object user  = zkClient.readData("/aganNode");
		System.out.println("user" + user);
	}


	public void updateNode() {
		User user = new User();
		user.setId(2);
		user.setName("ttttttt");
		/**
		 * testUserNode 节点的路径 user 传入的数据对象
		 */
		zkClient.writeData("/aganNode", user);
		System.out.println("修改aganNode节点成功" );
	}
	
	public void deleteNode(){
		//删除单独一个节点，返回true表示成功
        boolean e1 = zkClient.deleteRecursive("/aganNode");
//		boolean e1 = zkClient.deleteRecursive("/tbschedule");
        //返回 true表示节点成功 ，false表示删除失败
        System.out.println("删除aganNode节点是否成功："+e1);  
	}

	public static void main(String[] args) {
		NodeManager nm=new NodeManager();
		nm.createNode();
		nm.updateNode();
		nm.getNode();
		nm.deleteNode();
	}
}

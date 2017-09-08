package zk;

import org.I0Itec.zkclient.IZkStateListener;
import org.apache.zookeeper.Watcher;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
public class SubscribeStateListener implements IZkStateListener {

    public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
        System.out.println("handleStateChanged");
    }

    public void handleNewSession() throws Exception {
        System.out.println("handleNewSession");
    }

    public void handleSessionEstablishmentError(Throwable error) throws Exception {
        System.out.println("handleSessionEstablishmentError");
    }

}

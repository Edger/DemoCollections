package com.edger.ipc.manager;

import android.os.IBinder;

import com.edger.ipc.binder.IBookManager;

public class BookManager {
    private IBookManager mBookManager;

    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            if (mBookManager == null) {
                return;
            }
            mBookManager.asBinder().unlinkToDeath(mDeathRecipient, 0);
            mBookManager = null;
            // TODO: 这里重新绑定远程 service
        }
    };
}

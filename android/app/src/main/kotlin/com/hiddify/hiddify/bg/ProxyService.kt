package com.hiddify.hiddify.bg

import android.app.Service
import android.content.Intent
import com.hiddify.core.libbox.Notification

class ProxyService :
    Service(),
    PlatformInterfaceWrapper {
    private val service = BoxService(this, this)

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int) = service.onStartCommand()

    override fun onBind(intent: Intent) = service.onBind(intent)

    override fun onDestroy() = service.onDestroy()

    override fun sendNotification(notification: Notification) = service.sendNotification(notification)

    // 【新增】：补齐缺失的 closeNeighborMonitor 接口方法，防止 Kotlin 编译报错
    override fun closeNeighborMonitor() {
        // 留空即可，只需要让编译器知道有这个方法实现
    }
}

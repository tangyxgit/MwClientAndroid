package com.work.api.open.contacts;


/**
 * Created by tangyx on 15/9/18.
 *
 */
public final class ModeApi {
    /**
     *短信验证码
     */
    public final static String getSmsCode = "user.getSmsCode";
    /**
     * 登录
     */
    public final static String appLogin ="user.appLogin";
    public final static String loginFrom3rdParty="user.loginFrom3rdParty";
    /**
     * 删除排班
     */
    public final static String removeSchedulings ="scheduling.removeSchedulings";
    /**
     * 获取任务列表
     */
    public final static String listScheduling="scheduling.listScheduling";
    /**
     * 按车辆排序
     */
    public final static String listSchedulingByVehicle="scheduling.listSchedulingByVehicle";
    /**
     * 按司机排序
     */
    public final static String listSchedulingByDriver="scheduling.listSchedulingByDriver";
    /**
     * 变更订单状态
     */
    public final static String updateStatus="scheduling.updateStatus";
    /**
     * 获取订单详情
     */
    public final static String  getSchedulingFromId="scheduling.getSchedulingFromId";
    /**
     * 新增车辆
     */
    public final static String  addVehicle="vehicle.addVehicle";
    /**
     * 更新车辆
     */
    public final static String updateVehicle="vehicle.updateVehicle";
    /**
     * 获取车辆
     */
    public final static String listVehicle="vehicle.listVehicle";
    /**
     * 获取车辆详情
     */
    public final static String getVehicleFromId="vehicle.getVehicleFromId";
    /**
     * 删除车辆
     */
    public final static String removeVehicles="vehicle.removeVehicles";
    /**
     * 新增司机
     */
    public final static String addDriver="driver.addDriver";
    /**
     * 更新司机
     */
    public final static String updateDriver = "driver.updateDriver";
    /**
     * 获取司机
     */
    public final static String listDriver = "driver.listDriver";
    /**
     * 获取司机详情
     */
    public final static String getDriverFromId="driver.getDriverFromId";
    /**
     * 删除司机
     */
    public final static String removeDrivers="driver.removeDrivers";
    /**
     * 获取客户
     */
    public final static String listCustomer = "customer.listCustomer";
    /**
     * 获取客户资料
     */
    public final static String getCustomerFromId = "customer.getCustomerFromId";
    /**
     * 删除客户
     */
    public final static String removeCustomers="customer.removeCustomers";
    /**
     * 获取联系人
     */
    public final static String listContacts="contacts.listContacts";
    /**
     * 获取联系人总数
     */
    public final static String countContacts = "contacts.countContacts";
    /**
     * 获取用车单位总数
     */
    public final static String countCustomer = "customer.countCustomer";
    /**
     * 获取联系人详情
     */
    public final static String getContactsFromId = "contacts.getContactsFromId";
    /**
     * 新增联系人
     */
    public final static String addContacts = "contacts.addContacts";
    /**
     * 更新联系人
     */
    public final static String updateContacts = "contacts.updateContacts";
    /**
     * 删除联系人
     */
    public final static String removeContactss = "contacts.removeContactss";
    /**
     * 新增排班
     */
    public final static String addScheduling = "scheduling.addScheduling";
    /**
     * 更新排班
     */
    public final static String updateScheduling = "scheduling.updateScheduling";
    /**
     * 收车
     */
    public final static String closeScheduling = "scheduling.closeScheduling";
    /**
     * 新增客户
     */
    public final static String addCustomer = "customer.addCustomer";
    /**
     * 更新客户
     */
    public final static String updateCustomer = "customer.updateCustomer";
    /**
     * 监控所有车辆
     */
    public final static String getAllLngLatsGroup = "monitor.getAllLngLatsGroup";
    /**
     * 新增监控分组
     */
    public final static String vehicleGroupAdd = "vehicleGroup.add";
    /**
     * 编辑监控分组
     */
    public final static String vehicleGroupUpdate = "vehicleGroup.update";
    /**
     * 删除监控分组
     */
    public final static String vehicleGroupRemove = "vehicleGroup.remove";
    /**
     * 绑定监控分组车辆
     */
    public final static String vehicleGroupBind = "vehicleGroup.vehicleBindGroup";
    /**
     * 拒绝审批
     */
    public final static String approvalVeto = "approval.veto";
    /**
     * 同意审批
     */
    public final static String approvalApprove = "approval.approve";
    /**
     * 获取审批详情
     */
    public final static String getApproval = "approval.getApproval";
    /**
     * 获取消息列表
     */
    public final static String listMessage = "message.listMessage";
    /**
     * 获取消息详情
     */
    public final static String getMessageFromId = "message.getMessageFromId";
    /**
     * 标记已读
     */
    public final static String readMessages = "message.readMessages";
    /**
     * 获取未读消息数量
     */
    public final static String countMsg = "message.countMsg";
    /**
     * 获取轨迹
     */
    public final static String getRangeLngLats = "monitor.getRangeLngLats";
    /**
     * 注册
     */
    public final static String addManager = "user.addManager";
    public final static String addOrLoginFrom3rdParty="user.addOrLoginFrom3rdParty";
    /**
     * 获取操作指南列表
     */
    public final static String listQuestion = "question.listQuestion";
    /**
     * 获取操作指南详情
     */
    public final static String getQuestionFromId = "question.getQuestionFromId";
    /**
     * 通知抢单
     */
    public final static String setGrabing = "scheduling.setGrabing";
    /**
     * 统计排班数
     */
    public final static String countScheduling = "scheduling.countScheduling";
    /**
     * 获取分享小程序定位链接
     */
    public final static String getShareToken = "monitor.getShareToken";
    /**
     * 分享小程序轨迹链接
     */
    public final static String getShareRangeToken="monitor.getShareRangeToken";
    /**
     * 获取公司信息
     */
    public final static String updateToken = "user.updateToken";
    /**
     * 获取费用列表
     */
    public final static String listExpense = "expense.listExpense";
    /**
     * 财务结算账务计算
     */
    public final static String expenseProfile="expense.expenseProfile";
    /**
     * 获取费用详情
     */
    public final static String getExpenseFromId = "expense.getExpenseFromId";
    /**
     * 改变结清状态
     */
    public final static String updateExpenseSettlement = "expense.updateExpenseSettlement";
    /**
     * 删除费用
     */
    public final static String removeExpenses = "expense.removeExpenses";
    /**
     * 新增费用
     */
    public final static String addExpense = "expense.addExpense";
    /**
     * 编辑费用
     */
    public final static String updateExpense = "expense.updateExpense";
    /**
     * 获取费用类型列表
     */
    public final static String listExpenseType = "expenseType.listExpenseType";
    /**
     * 获取费用类型详情
     */
    public final static String getExpenseTypeFromId = "expenseType.getExpenseTypeFromId";
    /**
     * 删除费用类型
     */
    public final static String removeExpenseTypes = "expenseType.removeExpenseTypes";
    /**
     * 添加费用类型
     */
    public final static String addExpenseType = "expenseType.addExpenseType";
    /**
     * 排班报表
     */
    public final static String getSchedulingReport = "report.getSchedulingReport";
    /**
     * 行程报表
     */
    public final static String getTravelReport = "report.getTravelReport";
    /**
     * 财务报表
     */
    public final static String getExpenseReport = "report.getExpenseReport";
    /**
     * 获取自定义字段
     */
    public final static String listCustomize = "customize.listCustomize";
    /**
     * 获取oss上传的参数
     */
    public final static String getImageConfig = "operation.getImageConfig";
    /**
     * 新增排版获取订单类型
     */
    public final static String listOrderType = "orderType.listOrderType";
    /**
     * 编辑/新增的司机接口
     */
    public final static String listDriverByScheduling = "driver.listDriverByScheduling";
    /**
     * 编辑/新增的车辆接口
     */
    public final static String listVehicleByScheduling = "vehicle.listVehicleByScheduling";
    /**
     * 查看轨迹
     */
    public final static String getTravelTrack = "scheduling.getTravelTrack";
    /**
     * 操作历史记录
     */
    public final static String listHistory = "history.listHistory";
    /**
     * 提醒列表
     */
    public final static String listRemind = "remind.listRemind";
    /**
     * 新增提醒
     */
    public final static String addRemind = "remind.addRemind";
    /**
     * 获取提醒详情
     */
    public final static String getRemindFromId = "remind.getRemindFromId";
    /**
     * 更新提醒
     */
    public final static String updateRemind = "remind.updateRemind";
    /**
     * 提醒类型列表
     */
    public final static String listRemindType = "remind.listRemindType";
    /**
     * 已经完成的提醒
     */
    public final static String remindDone = "remind.done";
    /**
     * 删除提醒
     */
    public final static String removeReminds = "remind.removeReminds";
    /**
     * 获取电子围栏列表
     */
    public final static String listFence = "fence.listFence";
    /**
     * 添加电子围栏
     */
    public final static String addFence = "fence.addFence";
    /**
     * 更新电子围栏
     */
    public final static String updateFence = "fence.updateFence";
    /**
     * 电子围栏详情
     */
    public final static String getFenceFromId = "fence.getFenceFromId";
    /**
     * 删除电子围栏
     */
    public final static String removeFences = "fence.removeFences";
    /**
     * 罗列电子围栏的车辆
     */
    public final static String listVehicleInFence = "vehicle.listVehicleInFence";
    /**
     * 添加车辆到电子围栏
     */
    public final static String updateVehicles = "fenceVehicle.updateVehicles";
    /**
     * 罗列围栏里的车辆
     */
    public final static String listFenceVehicle = "fenceVehicle.listFenceVehicle";
    /**
     * 批量上传联系人
     */
    public final static String batchContacts = "contacts.batchContacts";
    /**
     * 用车审批
     */
    public final static String listForScheduling = "approval.listForScheduling";
    /**
     * 费用审批
     */
    public final static String listForExpense = "approval.listForExpense";
    /**
     * 罗列分组权限
     */
    public final static String listGroup = "group.listGroup";
    /**
     * 用户反馈
     */
    public final static String addFeedback = "feedback.addFeedback";
    /**
     * 断开/恢复油电
     */
    public final static String setOilStatus="monitor.setOilStatus";
    /**
     * 分享订单
     */
    public final static String getSharePath="scheduling.getSharePath";
    /**
     * 请假审批
     */
    public final static String listForLeave="approval.listForLeave";
    /**
     * 请假详情
     */
    public final static String getLeaveFromId="leave.getLeaveFromId";
    /**
     * 维保审批
     */
    public final static String listForMaintenance = "approval.listForMaintenance";
    /**
     * 维保详情
     */
    public final static String getMaintenanceFromId="maintenance.getMaintenanceFromId";
    /**
     * 查询违章
     */
    public final static String queryByVehicleId = "violation.queryByVehicleId";
    /**
     * 临时车辆查询
     */
    public final static String queryByPlateNo = "violation.queryByPlateNo";
    /**
     * 查询违章车辆
     */
    public final static String groupByVehicle = "violation.groupByVehicle";
    /**
     * 获取指定车辆的违章内容
     */
    public final static String listViolation = "violation.listViolation";
    /**
     * 模拟数据
     */
    public final static String getMockAllLngLatsGroup="mockData.getAllLngLatsGroup";
    /**
     * 模拟轨迹
     */
    public final static String mockGetRangeLngLats = "mockData.getRangeLngLats";
    /**
     * 关闭所有的通道
     */
    public final static String closeVideoByCompany = "video.closeVideoByCompany";
    /**
     * 检查版本更新
     */
    public final static String getLatestApp="appUpdate.getLatestApp";
    /**
     * 小红点提示
     */
    public final static String countForApproval = "approval.countForApproval";
    /**
     * 获取公告列表
     */
    public final static String listTask = "broadcast.listTask";
    /**
     * 获取模板列表
     */
    public final static String listTemplate = "broadcast.listTemplate";
    /**
     * 添加短信模板
     */
    public final static String addTemplate = "broadcast.addTemplate";
    /**
     * 删除短信模板
     */
    public final static String removeTemplate = "broadcast.removeTemplate";
    /**
     * 获取司机/用车人数量
     */
    public final static String receiversCount = "broadcast.receiversCount";
    /**
     * 计算出短信的消耗数量
     */
    public final static String countSms = "broadcast.countSms";
    /**
     * 创建群发任务
     */
    public final static String addTask = "broadcast.addTask";
    /**
     * 公告
     */
    public final static String listBroadCast = "adminBroadCast.listBroadCast";
    /**
     * 选择短信模板
     */
    public final static String listNotice = "notice.listNotice";
    /**
     * 获取城市
     */
    public final static String listCountry = "country.listCountry";
    /**
     * 请假报表
     */
    public final static String listLeave = "leave.listLeave";
    /**
     * 请假合计
     */
    public final static String countLeave = "leave.countLeave";
    public final static String getLeaveReport = "report.getLeaveReport";
    /**
     * 维保报表
     */
    public final static String listMaintenance="maintenance.listMaintenance";
    /**
     * 维保合计
     */
    public final static String countMaintenance = "maintenance.countMaintenance";
    public final static String getMaintenanceReport = "report.getMaintenanceReport";
    /**
     * 行程明细
     */
    public final static String listTravel = "vehicle.listTravel";
    /**
     * 获取邀请码
     */
    public final static String getReferral = "company.getReferral";
    /**
     * 获取邀请列表
     */
    public final static String listReferral="company.listReferral";
    /**
     * 获取交易记录
     */
    public final static String listDealBroadCast="adminBroadCast.listDealBroadCast";
    /**
     * 短信-账单明细
     */
    public final static String listBilling="billing.listBilling";
    /**
     * 短信-扣费明细
     */
    public final static String listSms="billing.listSms";
    /**
     * 短信-发送记录
     */
    public final static String listSendSms="billing.listSendSms";
    /**
     * 短信-语音记录
     */
    public final static String listSendTts="billing.listSendTts";
    /**
     * 违章账单记录
     */
    public final static String listWz="genericBill.listWz";
    /**
     * 站点记录
     */
    public final static String listStop="stop.listStop";
    /**
     * 用车类型
     */
    public final static String listSchAssignTypes="scheduling.listSchAssignTypes";
    /**
     * 动态获取菜单
     */
    public final static String listUserMenu="menu.listUserMenu";
    /**
     * 获取组织架构
     */
    public final static String listCustomerTree = "customer.listCustomerTree";
    /**
     * 城市列表
     */
    public final static String listCity = "city.listCity";
    /**
     * 油卡列表
     */
    public final static String listOilCard = "oilCard.listOilCard";
    /**
     * 添加油卡
     */
    public final static String addOilCard = "oilCard.add";
    /**
     * 更新油卡
     */
    public final static String updateOilCard="oilCard.update";
    /**
     * 获取油卡详情
     */
    public final static String getOilCardFromId = "oilCard.getOilCardFromId";
    /**
     * 删除油卡
     */
    public final static String removeOilCard = "oilCard.remove";
    /**
     * 充值或加油
     */
    public final static String addDetailOilCard = "oilCard.addDetail";
    /**
     * 删除充值或加油记录
     */
    public final static String removeDetailOilCard = "oilCard.removeDetail";
    /**
     * 获取油卡记录
     */
    public final static String listOilCardDetail = "oilCard.listOilCardDetail";
    /**
     * 获取客户订单
     */
    public final static String listSchOrder = "productOrder.listSchOrder";
    /**
     * 申请提现
     */
    public final static String withDraw = "productOrder.withDraw";
    /**
     * 退出登录
     */
    public final static String logout = "user.logout";
}

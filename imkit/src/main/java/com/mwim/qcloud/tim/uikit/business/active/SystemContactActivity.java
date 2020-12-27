package com.mwim.qcloud.tim.uikit.business.active;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.widget.Toast;

import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.mwim.qcloud.tim.uikit.modules.contact.ContactListView;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.work.api.open.Yz;
import com.work.api.open.model.GetUserListByMobilesReq;
import com.work.api.open.model.GetUserListByMobilesResp;
import com.work.api.open.model.client.OpenData;
import com.work.util.RegularUtils;
import com.work.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangyx
 * Date 2020/12/24
 * email tangyx@live.com
 */

public class SystemContactActivity extends BaseActivity {

    private ContactListView mContactListView;
    private Map<String,String> mContactsMaps;

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        mContactListView = findViewById(R.id.black_list);
        mContactListView.setOnItemClickListener(new ContactListView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ContactItemBean contact) {
                if(contact.getUserType()!=3){
                    Intent intent = new Intent(SystemContactActivity.this, FriendProfileActivity.class);
                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, contact.getId());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        setTitleName(R.string.text_new_contacts_phone);
        new SearchModelTask().execute();
    }


    @Override
    public int onCustomContentId() {
        return R.layout.activity_im_contact_blacklist;
    }

    @Override
    public void onResult(RequestWork req, ResponseWork resp) throws Exception {
        super.onResult(req, resp);
        if(resp.isSuccess()){
            if(resp instanceof GetUserListByMobilesResp){
                List<OpenData> data = ((GetUserListByMobilesResp) resp).getData();
                new MobileTask(data).execute();
            }
        }else{
            ToastUtil.warning(this,resp.getMessage());
        }
    }

    private class SearchModelTask extends AsyncTask<Void,Void,List<OpenData>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mContactsMaps = new HashMap<>();
        }

        @Override
        protected List<OpenData> doInBackground(Void... voids) {
            List<OpenData> contacts = new ArrayList<>();
            //获取联系人信息的Uri
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            //获取ContentResolver
            ContentResolver contentResolver = SystemContactActivity.this.getContentResolver();
            //查询数据，返回Cursor
            Cursor cursor = contentResolver.query(uri, null, null, null, null);
            if(cursor!=null){
                while(cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    String mobile = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    if(TextUtils.isEmpty(mobile)){
                        continue;
                    }
                    mobile = mobile.replaceAll(" ","");
                    if(mContactsMaps.containsKey(mobile) || !RegularUtils.isMobileSimple(mobile)){
                        continue;
                    }
//                    String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    OpenData contactPhone = new OpenData();
                    contactPhone.setMobile(mobile);
//                    contactPhone.set(mobile);
//                    chineseToPy(contactPhone);
                    mContactsMaps.put(mobile,name);
                    contacts.add(contactPhone);
                }
                cursor.close();
            }
            return contacts;
        }

        @Override
        protected void onPostExecute(List<OpenData> contactItemBeans) {
            super.onPostExecute(contactItemBeans);
            GetUserListByMobilesReq getUserListByMobilesReq = new GetUserListByMobilesReq();
            getUserListByMobilesReq.setParamVal(contactItemBeans);
            Yz.getSession().getUserListByMobiles(getUserListByMobilesReq,SystemContactActivity.this);
        }
    }

    private class MobileTask extends AsyncTask<Void,Void,List<ContactItemBean>>{

        private List<OpenData> data;

        public MobileTask(List<OpenData> data) {
            this.data = data;
        }

        @Override
        protected List<ContactItemBean> doInBackground(Void... voids) {
            List<ContactItemBean> contactItemBeans = new ArrayList<>();
            for (OpenData openData:data) {
                ContactItemBean contactItemBean = new ContactItemBean();
                contactItemBean.setId(openData.getUserId());
                contactItemBean.setSystemContacts(true);
                contactItemBean.setMobile(openData.getMobile());
                contactItemBean.setUserType(openData.getUserType());
                String icon = openData.getUserIcon();
                if(!TextUtils.isEmpty(icon)){
                    List<Object> iconUrl = new ArrayList<>();
                    iconUrl.add(icon);
                    contactItemBean.setIconUrlList(iconUrl);
                }
                contactItemBean.setNickname(mContactsMaps.get(openData.getMobile()));
                if(contactItemBean.getUserType()==1
                        || contactItemBean.getUserType()==2){
                    contactItemBean.setSystemRemark(getString(R.string.text_contacts_phone_nickname,openData.getNickName()));
                }
                contactItemBeans.add(contactItemBean);
            }
            return contactItemBeans;
        }

        @Override
        protected void onPostExecute(List<ContactItemBean> contactItemBeans) {
            super.onPostExecute(contactItemBeans);
            mContactListView.setDataSource(contactItemBeans);
        }
    }
}

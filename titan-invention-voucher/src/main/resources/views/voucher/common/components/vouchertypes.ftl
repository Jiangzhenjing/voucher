<option value="">请选择</option>
<option value="WaitActive" <#if voucherStatus == "WaitActive">selected</#if>>待激活</option>
<option value="Actived" <#if voucherStatus == "Actived">selected</#if>>已激活</option>
<option value="WaitConfirm" <#if voucherStatus == "WaitConfirm">selected</#if>>待确认</option>
<option value="Confirmed" <#if voucherStatus == "Confirmed">selected</#if>>已确认</option>
<option value="HandOver" <#if voucherStatus == "HandOver">selected</#if>>已交付</option>
<option value="Expired" <#if voucherStatus == "Expired">selected</#if>>已过期</option>

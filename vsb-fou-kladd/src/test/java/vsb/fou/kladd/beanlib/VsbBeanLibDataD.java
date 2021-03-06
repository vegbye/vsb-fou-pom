package vsb.fou.kladd.beanlib;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

public class VsbBeanLibDataD {

    private String data;
    private Date time;

    public static VsbBeanLibDataD newInstance(String data) {
        VsbBeanLibDataD d = new VsbBeanLibDataD();
        d.setData(data);
        d.setTime(new Date());
        return d;
    }

    @Override
    public boolean equals(Object annen) {
        return EqualsBuilder.reflectionEquals(this, annen);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return this.time;
    }

}

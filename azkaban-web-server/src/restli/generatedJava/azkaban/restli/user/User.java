
package azkaban.restli.user;

import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.schema.SchemaFormatType;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;


/**
 * Azkaban User restli info

 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Data Template. Generated from D:\\AzkabanOri\\azkaban-web-server\\src\\restli\\schemas\\azkaban\\restli\\user\\User.pdl.")
public class User
    extends RecordTemplate

{

    private  static User.Fields _fields = new User.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("namespace azkaban.restli.user/**Azkaban User restli info\r\n*/record User{userId:string,email:string}", SchemaFormatType.PDL));
    private final static RecordDataSchema.Field FIELD_UserId = SCHEMA.getField("userId");
    private final static RecordDataSchema.Field FIELD_Email = SCHEMA.getField("email");

    public User() {
        super(new DataMap(3, 0.75F), SCHEMA);
    }

    public User(DataMap data) {
        super(data, SCHEMA);
    }

    public static User.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for userId
     * 
     * @see User.Fields#userId
     */
    public boolean hasUserId() {
        return contains(FIELD_UserId);
    }

    /**
     * Remover for userId
     * 
     * @see User.Fields#userId
     */
    public void removeUserId() {
        remove(FIELD_UserId);
    }

    /**
     * Getter for userId
     * 
     * @see User.Fields#userId
     */
    public String getUserId(GetMode mode) {
        return obtainDirect(FIELD_UserId, String.class, mode);
    }

    /**
     * Getter for userId
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see User.Fields#userId
     */
    @Nonnull
    public String getUserId() {
        return obtainDirect(FIELD_UserId, String.class, GetMode.STRICT);
    }

    /**
     * Setter for userId
     * 
     * @see User.Fields#userId
     */
    public User setUserId(String value, SetMode mode) {
        putDirect(FIELD_UserId, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for userId
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#userId
     */
    public User setUserId(
        @Nonnull
        String value) {
        putDirect(FIELD_UserId, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for email
     * 
     * @see User.Fields#email
     */
    public boolean hasEmail() {
        return contains(FIELD_Email);
    }

    /**
     * Remover for email
     * 
     * @see User.Fields#email
     */
    public void removeEmail() {
        remove(FIELD_Email);
    }

    /**
     * Getter for email
     * 
     * @see User.Fields#email
     */
    public String getEmail(GetMode mode) {
        return obtainDirect(FIELD_Email, String.class, mode);
    }

    /**
     * Getter for email
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see User.Fields#email
     */
    @Nonnull
    public String getEmail() {
        return obtainDirect(FIELD_Email, String.class, GetMode.STRICT);
    }

    /**
     * Setter for email
     * 
     * @see User.Fields#email
     */
    public User setEmail(String value, SetMode mode) {
        putDirect(FIELD_Email, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for email
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#email
     */
    public User setEmail(
        @Nonnull
        String value) {
        putDirect(FIELD_Email, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public User clone()
        throws CloneNotSupportedException
    {
        return ((User) super.clone());
    }

    @Override
    public User copy()
        throws CloneNotSupportedException
    {
        return ((User) super.copy());
    }

    public static class Fields
        extends PathSpec
    {


        public Fields(List<String> path, String name) {
            super(path, name);
        }

        public Fields() {
            super();
        }

        public PathSpec userId() {
            return new PathSpec(getPathComponents(), "userId");
        }

        public PathSpec email() {
            return new PathSpec(getPathComponents(), "email");
        }

    }

}

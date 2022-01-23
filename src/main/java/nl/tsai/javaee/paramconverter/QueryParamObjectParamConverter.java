package nl.tsai.javaee.paramconverter;

import javax.ws.rs.ext.ParamConverter;

/**
 * Maps a single {@link javax.ws.rs.QueryParam} annotated param to a different type
 */
public class QueryParamObjectParamConverter implements ParamConverter<QueryParamObject> {
    @Override
    public QueryParamObject fromString(String value) {
        return new QueryParamObject(value);
    }

    @Override
    public String toString(QueryParamObject value) {
        return value.getName();
    }
}

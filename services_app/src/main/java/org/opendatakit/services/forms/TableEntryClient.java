package org.opendatakit.services.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by user on 02.02.17.
 */

public class TableEntryClient implements Comparable<TableEntryClient> {

    /**
     * The tableId this entry describes.
     */
    private String tableId;

    /**
     * The ETag of the most recently modified data row
     */
    private String dataETag;

    /**
     * The ETag of the TableDefinition
     */
    private String schemaETag;

    /**
     * The Id of connected office
     */
    private String officeId;

    protected TableEntryClient() {
    }

    public TableEntryClient(final String tableId, final String dataETag, final String schemaETag) {
        this.tableId = tableId;
        this.dataETag = dataETag;
        this.schemaETag = schemaETag;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(final String tableId) {
        this.tableId = tableId;
    }

    public String getDataETag() {
        return this.dataETag;
    }

    public void setDataETag(final String dataETag) {
        this.dataETag = dataETag;
    }

    public String getSchemaETag() {
        return schemaETag;
    }

    public void setSchemaETag(String schemaETag) {
        this.schemaETag = schemaETag;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tableId == null) ? 1 : tableId.hashCode());
        result = prime * result + ((dataETag == null) ? 1 : dataETag.hashCode());
        result = prime * result + ((schemaETag == null) ? 1 : schemaETag.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TableEntryClient)) {
            return false;
        }
        TableEntryClient other = (TableEntryClient) obj;
        return (tableId == null ? other.tableId == null : tableId.equals(other.tableId))
                && (dataETag == null ? other.dataETag == null : dataETag.equals(other.dataETag))
                && (schemaETag == null ? other.schemaETag == null : schemaETag.equals(other.schemaETag));
    }

    @Override
    public String toString() {
        return "TableEntry [tableId=" + tableId + ", dataETag=" + dataETag + ", schemaETag="
                + schemaETag + "]";
    }

    @Override
    public int compareTo(TableEntryClient o) {
        if ( tableId == null ) {
            if ( o.tableId != null ) {
                return -1;
            }
        } else if ( o.tableId == null ) {
            return 1;
        }
        int cmp = tableId.compareTo(o.tableId);
        if ( cmp != 0 ) {
            return cmp;
        }

        // schemaETags never collide unless everything
        // is identical...

        if ( schemaETag == null ) {
            if ( o.schemaETag != null ) {
                return -1;
            }
        } else if ( o.schemaETag == null ) {
            return 1;
        }
        cmp = schemaETag.compareTo(o.schemaETag);
        if ( cmp != 0 ) {
            return cmp;
        }

        return 0;
    }
}

package cz.muni.fi.pb162.project.geometry;


import java.util.Comparator;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable {
    private TreeMap<String, Vertex2D> vertex;
    private LinkedList<String> keys = new LinkedList<>();

    /**
     * @param map map
     */
    public LabeledPolygon(Map<String, Vertex2D> map) {
        super(map.values().toArray());
        vertex = new TreeMap<>(map);
        map.keySet().iterator().forEachRemaining(key -> keys.add(key));

    }

    public TreeMap<String, Vertex2D> getVertex() {
        return vertex;
    }

    public void setVertex(TreeMap<String, Vertex2D> vertex) {
        this.vertex = vertex;
    }

    public LinkedList<String> getKeys() {
        return keys;
    }

    public void setKeys(LinkedList<String> keys) {
        this.keys = keys;
    }

    /**
     * @param index vertex index, not negative number
     * @return
     */
    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index negative");
        }
        return vertex.get(keys.get(index % getNumVertices()));
    }

    /**
     * @return
     */
    @Override
    public int getNumVertices() {
        return vertex.size();
    }

    /**
     * @param label label under which the vertex is stored
     * @return vertex
     */
    @Override
    public Vertex2D getVertex(String label) {
        return vertex.get(label);
    }

    /**
     * @return collection
     */
    @Override
    public Collection<String> getLabels() {
        return Collections.unmodifiableSet(vertex.keySet());
    }

    /**
     * @param vertexx vertex which labels are searched
     * @return collection
     */
    @Override
    public Collection<String> getLabels(Vertex2D vertexx) {
        Set<String> labels = new TreeSet<>();
        vertex.forEach((key, value) -> {
            if (value.equals(vertexx)) {
                labels.add(key);
            }
        });
        return labels;
    }

    /**
     * @return collection
     */
    @Override
    public Collection<Vertex2D> getSortedVertices() {
        return vertex.values();
    }

    /**
     * @param comparator comparator object used to determine the ordering
     * @return collection
     */
    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        Set<Vertex2D> x = new TreeSet<Vertex2D>(comparator);
        vertex.values().stream().forEach(e -> x.add(e));
        return x;
    }

    /**
     * @return collection
     */
    public Collection<Vertex2D> duplicateVertices() {
        TreeSet<Vertex2D> originals = new TreeSet<>();
        TreeSet<Vertex2D> duplicates = new TreeSet<>();
        vertex.forEach((key, value) -> {
            if (originals.contains(value)) {
                duplicates.add(value);
            } else {
                originals.add(value);
            }
        });
        return duplicates;
    }

    /**
     * @author Jan Gavlík x445794@mail.muni.cz
     */

    public static class Builder implements Buildable<LabeledPolygon> {
        private static TreeMap<String, Vertex2D> vertex = new TreeMap<>();

        public static TreeMap<String, Vertex2D> getVertex() {
            return vertex;
        }

        public static void setVertex(TreeMap<String, Vertex2D> vertex) {
            Builder.vertex = vertex;
        }

        /**
         * @param label label
         * @param vert  vertex
         * @return builder iself
         */
        public Builder addVertex(String label, Vertex2D vert) {
            if (label == null) {
                throw new IllegalArgumentException("label");
            } else if (vert == null) {
                throw new IllegalArgumentException("vertex");
            }
            vertex.put(label, vert);
            return this;
        }

        /**
         * @return polygon
         */
        @Override
        public LabeledPolygon build() {
            LabeledPolygon x = new LabeledPolygon(vertex);
            vertex.clear();
            return x;
        }
    }
}

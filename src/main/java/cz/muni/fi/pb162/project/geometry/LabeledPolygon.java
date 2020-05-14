package cz.muni.fi.pb162.project.geometry;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable, PolygonWritable {
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
        Set<Vertex2D> x = new TreeSet<Vertex2D>();
        vertex.values().stream().forEach(e -> x.add(e));
        return x;
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

    @Override
    public void write(OutputStream os) throws IOException {
        vertex.entrySet().forEach(e -> {
            try {
                os.write((e.getValue().getX() +
                        " " + e.getValue().getY() + " " + e.getKey() + System.lineSeparator()).getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    @Override
    public void write(File file) throws IOException {
        write(new FileOutputStream(file));
    }

    /**
     * @param os byte output stream
     */
    public void writeJson(OutputStream os) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(vertex);

        try {
            os.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Jan Gavlík x445794@mail.muni.cz
     */

    public static class Builder implements Buildable<LabeledPolygon>, PolygonReadable {
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

        @Override
        public LabeledPolygon.Builder read(InputStream is) throws IOException {
            TreeMap<String, Vertex2D> vertexx = new TreeMap<>();

            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
                rd.lines().forEach(e -> {
                    String[] xy = e.split("\\s", 3);
                    vertexx.put(xy[2], new Vertex2D(Double.parseDouble(xy[0]), Double.parseDouble(xy[1])));
                });
            } catch (Exception e) {
                throw new IOException();
            }

            vertexx.entrySet().stream().forEach(e -> {
                addVertex(e.getKey(), e.getValue());
            });

            return this;
        }

        @Override
        public PolygonReadable read(File file) throws IOException {
            return read(new FileInputStream(file));

        }
    }
}

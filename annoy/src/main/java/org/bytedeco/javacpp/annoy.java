// Targeted by JavaCPP version 1.2.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

public class annoy extends org.bytedeco.javacpp.presets.annoy {
    static { Loader.load(); }

// Parsed from annoylib.h

// Copyright (c) 2013 Spotify AB
//
// Licensed under the Apache License, Version 2.0 (the "License"); you may not
// use this file except in compliance with the License. You may obtain a copy of
// the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// License for the specific language governing permissions and limitations under
// the License.

// #ifndef ANNOYLIB_H
// #define ANNOYLIB_H

// #include <stdio.h>
// #include <string>
// #include <sys/stat.h>
// #include <unistd.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <sys/types.h>
// #include <fcntl.h>
// #include <stddef.h>
// #include <stdint.h>

// #ifdef __MINGW32__
// #include "mman.h"
// #include <windows.h>
// #else
// #include <sys/mman.h>
// #endif

// #include <string.h>
// #include <math.h>
// #include <vector>
// #include <algorithm>
// #include <queue>
// #include <limits>

// This allows others to supply their own logger / error printer without
// requiring Annoy to import their headers. See RcppAnnoy for a use case.
// #ifndef __ERROR_PRINTER_OVERRIDE__
//   #define showUpdate(...) { fprintf(stderr, __VA_ARGS__ ); }
// #else
//   #define showUpdate(...) { __ERROR_PRINTER_OVERRIDE__( __VA_ARGS__ ); }
// #endif

// #ifndef ANNOY_NODE_ATTRIBUTE
//   #define ANNOY_NODE_ATTRIBUTE __attribute__((__packed__))
  // TODO: this is turned on by default, but may not work for all architectures! Need to investigate.
// #endif

public static class RandRandom extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public RandRandom() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public RandRandom(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RandRandom(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public RandRandom position(long position) {
        return (RandRandom)super.position(position);
    }

  // Default implementation of annoy-specific random number generator that uses rand() from standard library.
  // Owned by the AnnoyIndex, passed around to the distance metrics
  public native int flip();
  public native @Cast("size_t") long index(@Cast("size_t") long n);
}


public static class Angular extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Angular() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Angular(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Angular(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Angular position(long position) {
        return (Angular)super.position(position);
    }

  public static native @Cast("const char*") BytePointer name();
}

public static class Euclidean extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Euclidean() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Euclidean(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Euclidean(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Euclidean position(long position) {
        return (Euclidean)super.position(position);
    }

  public static native @Cast("const char*") BytePointer name();
}

@Name("AnnoyIndexInterface<int,float>") public static class AnnoyIndexInterface extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AnnoyIndexInterface(Pointer p) { super(p); }

  public native void add_item(int item, @Const FloatPointer w);
  public native void add_item(int item, @Const FloatBuffer w);
  public native void add_item(int item, @Const float[] w);
  public native void build(int q);
  public native @Cast("bool") boolean save(@Cast("const char*") BytePointer filename);
  public native @Cast("bool") boolean save(String filename);
  public native void unload();
  public native @Cast("bool") boolean load(@Cast("const char*") BytePointer filename);
  public native @Cast("bool") boolean load(String filename);
  public native float get_distance(int i, int j);
  public native void get_nns_by_item(int item, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntPointer result, @StdVector FloatPointer distances);
  public native void get_nns_by_item(int item, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntBuffer result, @StdVector FloatBuffer distances);
  public native void get_nns_by_item(int item, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector int[] result, @StdVector float[] distances);
  public native void get_nns_by_vector(@Const FloatPointer w, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntPointer result, @StdVector FloatPointer distances);
  public native void get_nns_by_vector(@Const FloatBuffer w, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntBuffer result, @StdVector FloatBuffer distances);
  public native void get_nns_by_vector(@Const float[] w, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector int[] result, @StdVector float[] distances);
  public native int get_n_items();
  public native void verbose(@Cast("bool") boolean v);
  public native void get_item(int item, FloatPointer v);
  public native void get_item(int item, FloatBuffer v);
  public native void get_item(int item, float[] v);
}

@Name("AnnoyIndex<int,float,Euclidean,Kiss64Random>") @NoOffset public static class AnnoyIndex extends AnnoyIndexInterface {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AnnoyIndex(Pointer p) { super(p); }


  public AnnoyIndex(int f) { super((Pointer)null); allocate(f); }
  private native void allocate(int f);

  public native int get_f();

  public native void add_item(int item, @Const FloatPointer w);
  public native void add_item(int item, @Const FloatBuffer w);
  public native void add_item(int item, @Const float[] w);

  public native void build(int q);

  public native @Cast("bool") boolean save(@Cast("const char*") BytePointer filename);
  public native @Cast("bool") boolean save(String filename);

  public native void reinitialize();

  public native void unload();

  public native @Cast("bool") boolean load(@Cast("const char*") BytePointer filename);
  public native @Cast("bool") boolean load(String filename);

  public native float get_distance(int i, int j);

  public native void get_nns_by_item(int item, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntPointer result, @StdVector FloatPointer distances);
  public native void get_nns_by_item(int item, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntBuffer result, @StdVector FloatBuffer distances);
  public native void get_nns_by_item(int item, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector int[] result, @StdVector float[] distances);

  public native void get_nns_by_vector(@Const FloatPointer w, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntPointer result, @StdVector FloatPointer distances);
  public native void get_nns_by_vector(@Const FloatBuffer w, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector IntBuffer result, @StdVector FloatBuffer distances);
  public native void get_nns_by_vector(@Const float[] w, @Cast("size_t") long n, @Cast("size_t") long search_k, @StdVector int[] result, @StdVector float[] distances);
  public native int get_n_items();
  public native void verbose(@Cast("bool") boolean v);

  public native void get_item(int item, FloatPointer v);
  public native void get_item(int item, FloatBuffer v);
  public native void get_item(int item, float[] v);
}

// #endif
// vim: tabstop=2 shiftwidth=2


// Parsed from kissrandom.h

// #ifndef KISSRANDOM_H
// #define KISSRANDOM_H

// #include <stdint.h>

// KISS = "keep it simple, stupid", but high quality random number generator
// http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf -> "Use a good RNG and build it into your code"
// http://mathforum.org/kb/message.jspa?messageID=6627731
// https://de.wikipedia.org/wiki/KISS_(Zufallszahlengenerator)

// 32 bit KISS
@NoOffset public static class Kiss32Random extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Kiss32Random(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Kiss32Random(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Kiss32Random position(long position) {
        return (Kiss32Random)super.position(position);
    }

  public native @Cast("uint32_t") int x(); public native Kiss32Random x(int x);
  public native @Cast("uint32_t") int y(); public native Kiss32Random y(int y);
  public native @Cast("uint32_t") int z(); public native Kiss32Random z(int z);
  public native @Cast("uint32_t") int c(); public native Kiss32Random c(int c);

  // seed must be != 0
  public Kiss32Random(@Cast("uint32_t") int seed/*=123456789*/) { super((Pointer)null); allocate(seed); }
  private native void allocate(@Cast("uint32_t") int seed/*=123456789*/);
  public Kiss32Random() { super((Pointer)null); allocate(); }
  private native void allocate();

  public native @Cast("uint32_t") int kiss();
  public native int flip();
  public native @Cast("size_t") long index(@Cast("size_t") long n);
}

// 64 bit KISS. Use this if you have more than about 2^24 data points ("big data" ;) )
@NoOffset public static class Kiss64Random extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Kiss64Random(Pointer p) { super(p); }

  public native @Cast("uint64_t") long x(); public native Kiss64Random x(long x);
  public native @Cast("uint64_t") long y(); public native Kiss64Random y(long y);
  public native @Cast("uint64_t") long z(); public native Kiss64Random z(long z);
  public native @Cast("uint64_t") long c(); public native Kiss64Random c(long c);

  // seed must be != 0
  public Kiss64Random(@Cast("uint64_t") long seed/*=1234567890987654321L*/) { super((Pointer)null); allocate(seed); }
  private native void allocate(@Cast("uint64_t") long seed/*=1234567890987654321L*/);
  public Kiss64Random() { super((Pointer)null); allocate(); }
  private native void allocate();

  public native @Cast("uint64_t") long kiss();
  public native int flip();
  public native @Cast("size_t") long index(@Cast("size_t") long n);
}

// #endif
// vim: tabstop=2 shiftwidth=2


}

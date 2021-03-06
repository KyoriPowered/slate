/*
 * This file is part of igloo, licensed under the MIT License.
 *
 * Copyright (c) 2018-2021 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.github.util;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * HTTP {@code Accept} header utilities.
 *
 * @since 2.0.0
 */
public interface Accept {
  /**
   * The header name.
   *
   * @since 2.0.0
   */
  String HEADER_NAME = "Accept";

  /**
   * Add {@code accept} to the {@code Accept} headers in {@code request}.
   *
   * @param request the request
   * @param accept the header
   * @since 2.0.0
   */
  static void add(final HttpRequest request, final String accept) {
    add(request, Collections.singletonList(accept));
  }

  /**
   * Add {@code accept} to the {@code Accept} headers in {@code request}.
   *
   * @param request the request
   * @param accept the headers
   * @since 2.0.0
   */
  static void add(final HttpRequest request, final List<String> accept) {
    final HttpHeaders headers = request.getHeaders();
    final List<String> result = new ArrayList<>(headers.getHeaderStringValues(HEADER_NAME));
    result.addAll(accept);
    headers.put(HEADER_NAME, result);
  }
}

/*
 * This file is part of igloo, licensed under the MIT License.
 *
 * Copyright (c) 2018 KyoriPowered
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
package net.kyori.igloo.v3;

import net.kyori.blizzard.NonNull;

import java.io.IOException;

/**
 * An {@link Issue issue}'s comments.
 */
public interface Comments {
  /**
   * Posts a new comment to the issue.
   *
   * @param body the issue body
   * @return the comment that was posted
   * @throws IOException if an exception occurs while posting the comment
   */
  @NonNull
  Comment post(@NonNull final Comment.Partial.Body body) throws IOException;

  final class Impl implements Comments {
    private final Request request;

    Impl(final Request request) {
      this.request = request.path("comments");
    }

    @NonNull
    @Override
    public Comment post(@NonNull final Comment.Partial.Body body) throws IOException {
      return new Comment.Impl(this.request.post(body, Partial.Id.class).id);
    }
  }
}
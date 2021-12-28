

									<c:forTokens var="star" items="${book.ratingStar}" delims=",">
                    					<c:if test="${star eq 'off' }">
                    						<i class="fas fa-star"></i>
                    					</c:if>
                    					<c:if test="${star eq 'on' }">
                    						<i class="fas fa-star text-warning"></i>
                    					</c:if>
                    					<c:if test="${star eq 'half' }">
                    						<i class="fas fa-star-half-alt text-warning"></i>
                    					</c:if>
                    				
                    				</c:forTokens>
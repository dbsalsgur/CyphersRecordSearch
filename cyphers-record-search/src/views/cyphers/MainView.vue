<template>
  <div>
    <Header/>
    <div class="d-flex flex-column align-items-center justify-content-center" style="height: 80vh;">
      <h1 class="display-1 mb-2">
        <img src="./img/rclogo3.png" class="d-inline-block align-top" alt="고먐미">
      </h1>
      <div class="input-group mb-3 w-50 position-relative"> <!-- 여기에 position-relative 추가 -->
        <input
            type="text"
            class="form-control form-control-lg"
            placeholder="검색어를 입력하세요"
            aria-label="검색어"
            aria-describedby="search-button"
            v-model="searchText"
            @input="handleInput"
            @focus="isInputFocused = true"
            @blur="handleBlur"
            @keyup.enter="search">
        <div class="input-group-append">
          <button 
              class="btn btn-primary btn-lg" 
              type="button" 
              id="search-button"
              @click="search">
              검색
          </button>
        </div>

        <!-- 자동완성 목록에 position-absolute와 top 스타일 추가 -->
        <ul v-if="isInputFocused" class="list-group w-100 position-absolute" style="top: 100%;">
          <li
              class="list-group-item list-group-item-action"
              v-for="item in searchData"
              :key="item.id"
              @mouseover="onHover"
              @mouseleave="onLeave"
              @mousedown="preventBlur = true"
              @click="selectAutocompleteItem(item.text)">
            {{ item.text }}
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Header from "./HeaderComponent.vue";

export default {
  components: {
    Header
  },
  data() {
    return {
      isInputFocused: false,
      searchText: '',
      searchData: [],
      timeout: null,
    }
  },
  methods: {
    handleBlur() {
      if (!this.preventBlur) {
        this.isInputFocused = false;
      }
    },
    onHover(event) {
      event.target.style.cursor = "pointer";
      event.target.style.backgroundColor = "#f5f5f5"; // 예시로 배경색 변경 추가. 원하는 스타일로 조절 가능
    },
    onLeave(event) {
      event.target.style.cursor = "default";
      event.target.style.backgroundColor = "white"; // hover 효과가 사라질 때 원래 상태로 되돌리기 위한 코드
    },
    selectAutocompleteItem(text) {
      this.searchText = text;
      this.isInputFocused = false;
    },
    handleInput(e) {
      this.searchText = e.target.value;

      if (this.searchText.length<2 || this.searchText.length>8) {
        this.searchData = [];
        return;
      } else {
        this.fetchData();
      }
    },
    fetchData() {
      axios.get(`/api/search/auto-complete/${this.searchText}`)
        .then(response => {
          this.searchData = [];
          for (let index = 0; index < response.data.length; index++) {
            this.searchData.push({'text': response.data[index], 'id' : index});
          }
        });
    },
    search() {
      localStorage.setItem("nickname", this.searchText);
      this.$router.push({ name: 'RecordDetail', params: { } });
    },
  },
  mounted() {
    
  }
}
</script>

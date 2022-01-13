import request from '@/utils/request'

// 查询打卡信息列表
export function listClock(query) {
  return request({
    url: '/system/clock/list',
    method: 'get',
    params: query
  })
}

// 查询打卡信息详细
export function getClock(userId) {
  return request({
    url: '/system/clock/' + userId,
    method: 'get'
  })
}

// 新增打卡信息
export function addClock(data) {
  return request({
    url: '/system/clock',
    method: 'post',
    data: data
  })
}

// 修改打卡信息
export function updateClock(data) {
  return request({
    url: '/system/clock',
    method: 'put',
    data: data
  })
}

// 删除打卡信息
export function delClock(userId) {
  return request({
    url: '/system/clock/' + userId,
    method: 'delete'
  })
}
